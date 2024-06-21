'use strict'
        window.addEventListener('load', () => {
          let priceList = {"cpu": 0, "gpu": 0, "memory": 0, "mb": 0, "ssd": 0, "psu": 0, "os": 0};

    //////URLのパラメータ受け取り//////
          let param = location.search.substring(1).split('&');
          let paramData = Number(param[0].split('='));

    //////新規か編集か判定
          let methodType="POST";
            if(paramData[1]===null || paramData[1]==="" || paramData[1]===undefined){
              methodType="PUT";
            }
    //////プリセット保存時に送信するオブジェクト//////
          let presetDataList = {
            "presetId": paramData[1],   //値が入っていなければ新規判定
            "presetName": "",
            "cpuId":    "", "cpuName":    "", "cpuUrl":    "",
            "gpuId":    "", "gpuName":    "", "gpuUrl":    "",
            "memoryId": "", "memoryName": "", "memoryUrl": "",
            "mbId":     "", "mbName":     "", "mbUrl":     "",
            "ssdId":    "", "ssdName":    "", "ssdUrl":    "",
            "psuId":    "", "psuName":    "", "psuUrl":    "",
            "osId":     "", "osName":     "", "osUrl":     "",
            "description": "",
            "totalPrice":0
          };

    //////////モーダル表示///////////
          const selectButtons = document.querySelectorAll('button[data-bs-toggle="modal"]');
          selectButtons.forEach(button => {
            button.addEventListener('click', function(event){
              const partsCategoryName = event.currentTarget.getAttribute('data-name');
              document.getElementById('selectModalLabel').setAttribute('data-name', partsCategoryName);
              document.getElementById('selectModalLabel').value=partsCategoryName;
              const partsList = document.getElementById('partsList');
              partsList.innerHTML = '';

              let data;
              let selectModalTitle;

              let chipset="";
              let cpuGen="";
              switch(document.getElementById('selectModalLabel').value){
                case 'CPU':
                  selectModalTitle = 'CPU';
                  data = fetch(`/api/searchByCpuList`,{
                    method: 'GET',
                    headers: {
                   'Content-Type': 'application/json',
                 },
                 body: JSON.stringify(createSearchData(
                    searchWord,
                    minPrice,
                    maxPrice,
                    chipset
                  )),
                })
                case 'GPU':
                  selectModalTitle = 'グラフィックボード';
                  data = fetch(`/api/getGpuList`);
                  break;
                case 'MEMORY':
                  selectModalTitle = 'メモリ';
                  data = fetch(`/api/getRamList`);
                  break;
                case 'MB':
                  selectModalTitle = 'マザーボード';
                  data = fetch(`/api/searchByMbList`,{
                    method: 'GET',
                    headers: {
                   'Content-Type': 'application/json',
                 },
                 body: JSON.stringify(createSearchData(
                    searchWord,
                    minPrice,
                    maxPrice,
                    cpuGen
                  )),
                });
                  break;
                case 'SSD':
                  selectModalTitle = 'SSD';
                  data = fetch(`/api/getBySsdList`);
                  break;
                case 'PSU':
                  selectModalTitle = '電源';
                  data = fetch(`/api/getByPsuList`);
                  break;
                case 'OS':
                  selectModalTitle = 'OS';
                  data = fetch(`/api/getOsList`);
                  break;
              }
              document.getElementById('selectModalLabel').textContent = selectModalTitle + 'を選択';

              let dataObj;
              const partsCard = `
                  <div class="card my-2 border-primary-subtle border-3 parts-card" data-bs-dismiss="modal">
                    <div class="card-body border border-0 py-3 list-group-item list-group-item-action" aria-current="true">
                      <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-2 name"></h5>
                        <h5 class="text-danger price"></h5>
                      </div>
                      <span class="badge text-secondary border border-1 border-secondary rounded-5 spec1"></span>
                      <span class="badge text-secondary border border-1 border-secondary rounded-5 spec2"></span>
                      <span class="badge text-secondary border border-1 border-secondary rounded-5 spec3"></span>
                      <span class="badge text-secondary border border-1 border-secondary rounded-5 spec4"></span>
                      <small class="float-end release"></small>
                    </div>
                  </div>`;
              partsList.insertAdjacentHTML('beforeend', partsCard);
              partsList.querySelectorAll('.parts-card')[0].setAttribute('data-id', null);
              partsList.querySelectorAll(".name")[0].textContent = "未選択";
              partsList.querySelectorAll(".price")[0].textContent = '¥0';
              if (partsList.querySelectorAll(".spec1")[0] != null) {
                partsList.querySelectorAll(".spec1")[0].textContent = dataObj?.[5];
              }
              if (partsList.querySelectorAll(".spec2")[0] != null) {
                partsList.querySelectorAll(".spec2")[0].textContent = dataObj?.[6];
                if(document.getElementById('selectModalLabel').value==="MB"){
                  cpuGen=dataObj?.[6];
                }
              }
              if (partsList.querySelectorAll(".spec3")[0] != null) {
                partsList.querySelectorAll(".spec3")[0].textContent = dataObj?.[7];
              }
              if (partsList.querySelectorAll(".spec4")[0] != null) {
                partsList.querySelectorAll(".spec4")[0].textContent = dataObj?.[8];
                if(document.getElementById('selectModalLabel').value==="CPU"){
                  cpuGen=dataObj?.[8];
                }
              }
              partsList.querySelectorAll(".release")[0].textContent = dataObj?.[4];
              for (let i = 0; i < data.length; i++) {
                dataObj = Object.values(data[i]);
                partsList.insertAdjacentHTML('beforeend', partsCard);
                partsList.querySelectorAll('.parts-card')[i].setAttribute('data-id', dataObj?.[0]);
                partsList.querySelectorAll(".name")[i].textContent = dataObj?.[2];
                partsList.querySelectorAll(".price")[i].textContent = '¥' + dataObj?.[3].toLocaleString();
                if (partsList.querySelectorAll(".spec1")[i] != null) {
                  partsList.querySelectorAll(".spec1")[i].textContent = dataObj?.[5];
                }
                if (partsList.querySelectorAll(".spec2")[i] != null) {
                  partsList.querySelectorAll(".spec2")[i].textContent = dataObj?.[6];
                  if(document.getElementById('selectModalLabel').value==="MB"){
                    cpuGen=dataObj?.[6];
                  }
                }
                if (partsList.querySelectorAll(".spec3")[i] != null) {
                  partsList.querySelectorAll(".spec3")[i].textContent = dataObj?.[7];
                }
                if (partsList.querySelectorAll(".spec4")[i] != null) {
                  partsList.querySelectorAll(".spec4")[i].textContent = dataObj?.[8];
                  if(document.getElementById('selectModalLabel').value==="CPU"){
                    cpuGen=dataObj?.[8];
                  }
                }
                partsList.querySelectorAll(".release")[i].textContent = dataObj?.[4];

    ////////////選択パーツのデータをlistや各タグに格納////////////
                const cards = document.querySelectorAll('.parts-card');
                cards.forEach(function(card) {
                  card.addEventListener('click', function() {
                    const partsCategoryName = document.getElementById('selectModalLabel').getAttribute('data-name').toLowerCase();
                    const partsCategoryCard = document.getElementById(partsCategoryName)
                    const dataId = card.getAttribute('data-id');
                    const selectPartsList = Object.values(data.find(item => item.product_id === dataId));

                    partsCategoryCard.querySelector(".price").textContent = '¥' + selectPartsList?.[3].toLocaleString();
                    partsCategoryCard.querySelector(".name").textContent = selectPartsList?.[2];
                    if (partsCategoryCard.querySelector(".spec1") != null) {
                      partsCategoryCard.querySelector(".spec1").textContent = selectPartsList?.[5];
                    }
                    if (partsCategoryCard.querySelector(".spec2") != null) {
                      partsCategoryCard.querySelector(".spec2").textContent = selectPartsList?.[6];
                    }
                    if (partsCategoryCard.querySelector(".spec3") != null) {
                      partsCategoryCard.querySelector(".spec3").textContent = selectPartsList?.[7];
                    }
                    if (partsCategoryCard.querySelector(".spec4") != null) {
                      (partsCategoryCard.querySelector(".spec4").textContent = selectPartsList?.[8]);
                    }

                    priceList[partsCategoryName] = selectPartsList?.[3];
                    let totalPrice = Object.values(priceList).reduce((acc, curr) => acc + curr, 0);
                    document.getElementById("totalPrice").textContent = '¥' + totalPrice.toLocaleString();

    ////////////////プリセットデータ格納//////////////
                    presetDataList[partsCategoryName + "Id"] = selectPartsList[0];
                    presetDataList[partsCategoryName + "Name"] = selectPartsList?.[2];
                    presetDataList[partsCategoryName + "Url"] = selectPartsList?.[1];
                    presetDataList["description"] = document.getElementById("description").value;
                    presetDataList["totalPrice"] = totalPrice;
                    presetDataList["presetName"] = document.getElementById("presetName").value;

                    console.log(presetDataList);
                  });
                });

              }
            });
          });

        document.getElementById('presetSaveBtn').addEventListener('click', () => {
            fetch('/api/PresetListFormRegistration', {
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(presetDataList),
            })
           .then(res =>
               console.log(res)
               )
        })

        /////検索////
        document.getElementById('searchBtn').addEventListener('click', function(){
          let searchWord = document.getElementById('searchWord').Value;
          let minPrice = document.getElementById('minPrice').Value;
          let maxPrice = document.getElementById('maxPrice').Value;

          switch(document.getElementById('selectModalLabel').value){
            case 'CPU':
              let chipset=document.getElementById('spec4MB').value;
              selectModalTitle = 'CPU';
              data = fetch(`/api/searchByCpuList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice,
                chipset
              )),
            })
            .then(res =>
              console.log(res)
              )
            case 'GPU':
              selectModalTitle = 'グラフィックボード';
              data = fetch(`/api/searchByGpuList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice
              )),
            });
              break;
            case 'MEMORY':
              selectModalTitle = 'メモリ';
              data = fetch(`/api/searchByRamList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice
              )),
            });
              break;
            case 'MB':
              let cpuGen=document.getElementById('spec4CPU').value;
              selectModalTitle = 'マザーボード';
              data = fetch(`/api/searchByMbList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice,
                cpuGen
              )),
            });
              break;
            case 'SSD':
              selectModalTitle = 'SSD';
              data = fetch(`/api/searchBySsdList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice
              )),
            });
              break;
            case 'PSU':
              selectModalTitle = '電源';
              data = fetch(`/api/searchByPsuList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice
              )),
            });
              break;
            case 'OS':
              selectModalTitle = 'OS';
              data = fetch(`/api/searchByOsList`,{
                method: 'GET',
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(createSearchData(
                searchWord,
                minPrice,
                maxPrice
              )),
            });
            break;
        }
        let dataObj;
            const partsCard = `
                <div class="card my-2 border-primary-subtle border-3 parts-card" data-bs-dismiss="modal">
                  <div class="card-body border border-0 py-3 list-group-item list-group-item-action" aria-current="true">
                    <div class="d-flex w-100 justify-content-between">
                      <h5 class="mb-2 name"></h5>
                      <h5 class="text-danger price"></h5>
                    </div>
                    <span class="badge text-secondary border border-1 border-secondary rounded-5 spec1"></span>
                    <span class="badge text-secondary border border-1 border-secondary rounded-5 spec2"></span>
                    <span class="badge text-secondary border border-1 border-secondary rounded-5 spec3"></span>
                    <span class="badge text-secondary border border-1 border-secondary rounded-5 spec4"></span>
                    <small class="float-end release"></small>
                  </div>
                </div>`;
            partsList.insertAdjacentHTML('beforeend', partsCard);
            partsList.querySelectorAll('.parts-card')[i].setAttribute('data-id', null);
            partsList.querySelectorAll(".name")[i].textContent = "未選択";
            partsList.querySelectorAll(".price")[i].textContent = '¥0' + dataObj?.[3].toLocaleString();
            if (partsList.querySelectorAll(".spec1")[i] != null) {
              partsList.querySelectorAll(".spec1")[i].textContent = dataObj?.[5];
            }
            if (partsList.querySelectorAll(".spec2")[i] != null) {
              partsList.querySelectorAll(".spec2")[i].textContent = dataObj?.[6];
              if(document.getElementById('selectModalLabel').value==="MB"){
                cpuGen=dataObj?.[6];
              }
            }
            if (partsList.querySelectorAll(".spec3")[i] != null) {
              partsList.querySelectorAll(".spec3")[i].textContent = dataObj?.[7];
            }
            if (partsList.querySelectorAll(".spec4")[i] != null) {
              partsList.querySelectorAll(".spec4")[i].textContent = dataObj?.[8];
              if(document.getElementById('selectModalLabel').value==="CPU"){
                cpuGen=dataObj?.[8];
              }
            }
            partsList.querySelectorAll(".release")[i].textContent = dataObj?.[4];
            for (let i = 0; i < data.length; i++) {
              dataObj = Object.values(data[i]);
              partsList.insertAdjacentHTML('beforeend', partsCard);
              partsList.querySelectorAll('.parts-card')[i].setAttribute('data-id', dataObj?.[0]);
              partsList.querySelectorAll(".name")[i].textContent = dataObj?.[2];
              partsList.querySelectorAll(".price")[i].textContent = '¥' + dataObj?.[3].toLocaleString();
              if (partsList.querySelectorAll(".spec1")[i] != null) {
                partsList.querySelectorAll(".spec1")[i].textContent = dataObj?.[5];
              }
              if (partsList.querySelectorAll(".spec2")[i] != null) {
                partsList.querySelectorAll(".spec2")[i].textContent = dataObj?.[6];
                if(document.getElementById('selectModalLabel').value==="MB"){
                  cpuGen=dataObj?.[6];
                }
              }
              if (partsList.querySelectorAll(".spec3")[i] != null) {
                partsList.querySelectorAll(".spec3")[i].textContent = dataObj?.[7];
              }
              if (partsList.querySelectorAll(".spec4")[i] != null) {
                partsList.querySelectorAll(".spec4")[i].textContent = dataObj?.[8];
                if(document.getElementById('selectModalLabel').value==="CPU"){
                  cpuGen=dataObj?.[8];
                }
              }
              partsList.querySelectorAll(".release")[i].textContent = dataObj?.[4];
        };

      ////////検索メソッドに送るオブジェクトの作成////////
      function createSearchData(searchWord,minPrice,maxPrice,...compatible){
        if(compatible.length>0){
          return {
            "searchWord":searchWord,
            "minPrice":minPrice,
            "maxPrice":maxPrice,
            "compatible":compatible[0]
          };
        }else{
          return {
            "searchWord":searchWord,
            "minPrice":minPrice,
            "maxPrice":maxPrice
          };
        }
      }
  })
});