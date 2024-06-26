
'use strict'
    window.addEventListener('load', () => {
      let priceList = {"cpu": 0, "gpu": 0, "memory": 0, "mb": 0, "ssd": 0, "psu": 0, "os": 0};

      //////URLのパラメータ受け取り//////
      let param = location.search.substring(1).split('&');
      let paramData = param[0].split('=');

      //////互換性チェック用変数//////
      let mbChipsetFilter = "";
      let cpuGenFilter = "";

      //////新規か編集か判定
      let methodType="Put";
      if(paramData[1] === null || paramData[1] == 0 || paramData[1] === undefined || paramData[1] === ""){
        methodType="Post";
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
        "totalPrice": 0
      };

      //////////モーダル表示///////////
      const selectButtons = document.querySelectorAll('button[data-bs-toggle="modal"]');
      selectButtons.forEach(button => {
        button.addEventListener('click', async function(event){
          let searchWord = document.getElementById('searchWord').value = null;
          let minPrice = document.getElementById('minPrice').value = null;
          let maxPrice = document.getElementById('maxPrice').value = null;
          const partsCategoryName = event.currentTarget.getAttribute('data-name');
          document.getElementById('selectModalLabel').setAttribute('data-name', partsCategoryName);
          document.getElementById('selectModalLabel').value=partsCategoryName;
          const partsList = document.getElementById('partsList');
          partsList.innerHTML = '';
          let requestPram="searchWord=" + "&minPrice=" + "&maxPrice=";

          if (document.getElementById('selectModalLabel').value == 'CPU') {
            if (mbChipsetFilter != '') {
              document.getElementById("warning").textContent = '選択したマザーボードのチップセット(' + mbChipsetFilter + ')と互換性があるパーツのみ表示されています。';
            } else {
              document.getElementById("warning").textContent = null;
            }
          }
          if (document.getElementById('selectModalLabel').value == 'MB') {
            if (cpuGenFilter != '') {
              document.getElementById("warning").textContent = '選択したCPUの世代(' + cpuGenFilter + ')と互換性があるパーツのみ表示されています。';
            } else {
              document.getElementById("warning").textContent = null;
            }
          }

          let res; //JSONデータ
          let data; //JSONデータ内の内容を入れる
          let selectModalTitle;
          switch(document.getElementById('selectModalLabel').value){
            case 'CPU':
              selectModalTitle = 'CPU';
              requestPram += "&chipset=" + mbChipsetFilter;
              res = await fetch(`/api/searchByCpuList?` + requestPram);
              break;
            case 'GPU':
              selectModalTitle = 'グラフィックボード';
              res = await fetch(`/api/searchByGpuList?` + requestPram);
              break;
            case 'MEMORY':
              selectModalTitle = 'メモリ';
              res = await fetch(`/api/getRamList`);
              break;
            case 'MB':
              selectModalTitle = 'マザーボード';
              requestPram += "&cpuGen=" + cpuGenFilter;
              res = await fetch(`/api/searchByMbList?` + requestPram);
              break;
            case 'SSD':
              selectModalTitle = 'SSD';
              res = await fetch(`/api/getBySsdList`);
              break;
            case 'PSU':
              selectModalTitle = '電源';
              res = await fetch(`/api/getByPsuList`);
              break;
            case 'OS':
              selectModalTitle = 'OS';
              res = await fetch(`/api/getOsList`);
              break;
          }

          data=res.json();
          data.then(dataList => {
            dataList = dataList.filter(item => item.product_id !== null);
            let dataObj;
            document.getElementById('selectModalLabel').textContent = selectModalTitle + 'を選択';

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
            // 未選択を追加
            partsList.insertAdjacentHTML('beforeend', partsCard);
            partsList.querySelectorAll('.parts-card')[0].setAttribute('data-id', "");
            partsList.querySelectorAll(".name")[0].textContent = "未選択";
            partsList.querySelectorAll(".price")[0].textContent = '¥0';
            partsList.querySelectorAll(".spec1")[0].textContent = "";
            partsList.querySelectorAll(".spec2")[0].textContent = "";
            partsList.querySelectorAll(".spec3")[0].textContent = "";
            partsList.querySelectorAll(".spec4")[0].textContent = "";
            
            
            partsList.querySelectorAll(".release")[0].textContent = "";

            //JSONデータをモーダルに表示
            for (let i = 1; i < dataList.length + 1; i++) {
              dataObj = Object.values(dataList[i-1]);

              partsList.insertAdjacentHTML('beforeend', partsCard);
              partsList.querySelectorAll('.parts-card')[i].setAttribute('data-id', dataObj?.[1]);
              partsList.querySelectorAll(".name")[i].textContent = dataObj?.[3];
              partsList.querySelectorAll(".price")[i].textContent = '¥' + dataObj?.[4].toLocaleString();
              if (partsList.querySelectorAll(".spec1")[i] != null) {
                partsList.querySelectorAll(".spec1")[i].textContent = dataObj?.[6];
              }
              if (partsList.querySelectorAll(".spec2")[i] != null) {
                partsList.querySelectorAll(".spec2")[i].textContent = dataObj?.[7];
              }
              if (partsList.querySelectorAll(".spec3")[i] != null) {
                partsList.querySelectorAll(".spec3")[i].textContent = dataObj?.[8];
              }
              if (partsList.querySelectorAll(".spec4")[i] != null) {
                partsList.querySelectorAll(".spec4")[i].textContent = dataObj?.[9];
              }
              partsList.querySelectorAll(".release")[i].textContent = dataObj?.[5];

              ////////////選択パーツのデータをlistや各タグに格納////////////
              const cards = document.querySelectorAll('.parts-card');
              cards.forEach(function(card) {
                card.addEventListener('click', function() {
                  const partsCategoryName = document.getElementById('selectModalLabel').getAttribute('data-name').toLowerCase();
                  const partsCategoryCard = document.getElementById(partsCategoryName)
                  const dataId = card.getAttribute('data-id');
                  let selectPartsList;
                  if(dataId === null || dataId=== "" || dataId === undefined){
                    selectPartsList = Object.values({
                      "id": "",
                      "product_id": "",
                      "url": "",
                      "product_name": "未選択",
                      "price": 0,
                      "release_date": ""
                    });
                  }else{
                    selectPartsList = Object.values(dataList.find(item => item.product_id === dataId));
                  }
                  partsCategoryCard.querySelector(".price").textContent = '¥' + selectPartsList?.[4].toLocaleString();
                  partsCategoryCard.querySelector(".name").textContent = selectPartsList?.[3];
                  if (partsCategoryCard.querySelector(".spec1") != null) {
                    partsCategoryCard.querySelector(".spec1").textContent = selectPartsList?.[6];
                  }
                  if (partsCategoryCard.querySelector(".spec2") != null) {
                    partsCategoryCard.querySelector(".spec2").textContent = selectPartsList?.[7];
                  }
                  if (partsCategoryCard.querySelector(".spec3") != null) {
                    partsCategoryCard.querySelector(".spec3").textContent = selectPartsList?.[8];
                  }
                  if (partsCategoryCard.querySelector(".spec4") != null) {
                    partsCategoryCard.querySelector(".spec4").textContent = selectPartsList?.[9];
                  }

                  priceList[document.getElementById('selectModalLabel').value] = selectPartsList?.[4];
                  let totalPrice = Object.values(priceList).reduce((acc, curr) => acc + curr, 0);
                  document.getElementById(document.getElementById('selectModalLabel').value+"Price").textContent = '¥' + priceList[partsCategoryName];
                  document.getElementById("totalPrice").textContent = '¥' + totalPrice.toLocaleString();
                  document.getElementById("sideTotalPrice").textContent='¥' + totalPrice.toLocaleString();

                  if (document.getElementById('selectModalLabel').value == 'CPU') {
                    cpuGenFilter = selectPartsList?.[9] != undefined ? selectPartsList?.[9] : '';
                  }
                  if (document.getElementById('selectModalLabel').value == 'MB') {
                    mbChipsetFilter = selectPartsList?.[7] != undefined ? selectPartsList?.[7] : '';
                  }

                  ////////////////プリセットデータ格納//////////////
                  presetDataList[partsCategoryName + "Id"] = selectPartsList[1];
                  presetDataList[partsCategoryName + "Name"] = selectPartsList?.[3];
                  presetDataList[partsCategoryName + "Url"] = selectPartsList?.[2];
                  presetDataList["totalPrice"] = totalPrice;
                });
              });

            }
          });
        })

      });

      /////検索////
      document.getElementById('searchBtn').addEventListener('click', async function(){
        partsList.innerHTML = '';
        let searchWord = document.getElementById('searchWord').value;
        let minPrice = document.getElementById('minPrice').value;
        let maxPrice = document.getElementById('maxPrice').value;
        let requestPram="searchWord=" + searchWord + "&minPrice=" + minPrice + "&maxPrice=" + maxPrice;
        let selectModalTitle;
        let res;
        switch(document.getElementById('selectModalLabel').value){
          case 'CPU':
            selectModalTitle = 'CPU';
            requestPram += "&chipset=" + mbChipsetFilter;
            res = await fetch(`/api/searchByCpuList?` + requestPram);
            break;
          case 'GPU':
            selectModalTitle = 'グラフィックボード';
            res = await fetch(`/api/searchByGpuList?` + requestPram);
            break;
          case 'MEMORY':
            selectModalTitle = 'メモリ';
            res = await fetch(`/api/searchByRamList?` + requestPram);
            break;
          case 'MB':
            selectModalTitle = 'マザーボード';
            requestPram += "&cpuGen=" + cpuGenFilter;
            res = await fetch(`/api/searchByMbList?` + requestPram);
            break;
          case 'SSD':
            selectModalTitle = 'SSD';
            res = await fetch(`/api/searchBySsdList?` + requestPram);
            break;
          case 'PSU':
            selectModalTitle = '電源';
            res = await fetch(`/api/searchByPsuList?` + requestPram);
            break;
          case 'OS':
            selectModalTitle = 'OS';
            res = await fetch(`/api/searchByOsList?` + requestPram);
            break;
        }
        console.log(requestPram);

        let data=res.json();
        data.then(dataList => {
          dataList = dataList.filter(item => item.product_id !== null);
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
          partsList.querySelectorAll(".spec1")[0].textContent = '';
          partsList.querySelectorAll(".spec2")[0].textContent = '';
          partsList.querySelectorAll(".spec3")[0].textContent = '';
          partsList.querySelectorAll(".spec4")[0].textContent = '';
          partsList.querySelectorAll(".release")[0].textContent = '';
          for (let i = 1; i < dataList.length + 1; i++) {
            dataObj = Object.values(dataList[i]);
            partsList.insertAdjacentHTML('beforeend', partsCard);
            partsList.querySelectorAll('.parts-card')[i].setAttribute('data-id', dataObj?.[1]);
            partsList.querySelectorAll(".name")[i].textContent = dataObj?.[3];
            partsList.querySelectorAll(".price")[i].textContent = '¥' + dataObj?.[4];
            if (partsList.querySelectorAll(".spec1")[i] != null) {
              partsList.querySelectorAll(".spec1")[i].textContent = dataObj?.[6];
            }
            if (partsList.querySelectorAll(".spec2")[i] != null) {
              partsList.querySelectorAll(".spec2")[i].textContent = dataObj?.[7];
            }
            if (partsList.querySelectorAll(".spec3")[i] != null) {
              partsList.querySelectorAll(".spec3")[i].textContent = dataObj?.[8];
            }
            if (partsList.querySelectorAll(".spec4")[i] != null) {
              partsList.querySelectorAll(".spec4")[i].textContent = dataObj?.[9];
            }
            partsList.querySelectorAll(".release")[i].textContent = dataObj?.[5];
          };
          ////////////選択パーツのデータをlistや各タグに格納////////////
          const cards = document.querySelectorAll('.parts-card');
          cards.forEach(function(card) {
            card.addEventListener('click', function() {
              const partsCategoryName = document.getElementById('selectModalLabel').getAttribute('data-name').toLowerCase();
              const partsCategoryCard = document.getElementById(partsCategoryName)
              const dataId = card.getAttribute('data-id');
              let selectPartsList;
              if(dataId === null || dataId=== "" || dataId === undefined){
                selectPartsList = Object.values({
                  "id": "",
                  "product_id": "",
                  "url": "",
                  "product_name": "未選択",
                  "price": 0,
                  "release_date": ""
                });
              }else{
                selectPartsList = Object.values(dataList.find(item => item.product_id === dataId));
              }
              partsCategoryCard.querySelector(".price").textContent = '¥' + selectPartsList?.[4].toLocaleString();
              partsCategoryCard.querySelector(".name").textContent = selectPartsList?.[3];
              if (partsCategoryCard.querySelector(".spec1") != null) {
                partsCategoryCard.querySelector(".spec1").textContent = selectPartsList?.[6];
              }
              if (partsCategoryCard.querySelector(".spec2") != null) {
                partsCategoryCard.querySelector(".spec2").textContent = selectPartsList?.[7];
              }
              if (partsCategoryCard.querySelector(".spec3") != null) {
                partsCategoryCard.querySelector(".spec3").textContent = selectPartsList?.[8];
              }
              if (partsCategoryCard.querySelector(".spec4") != null) {
                partsCategoryCard.querySelector(".spec4").textContent = selectPartsList?.[9];
              }

              priceList[document.getElementById('selectModalLabel').value] = selectPartsList?.[4];
              let totalPrice = Object.values(priceList).reduce((acc, curr) => acc + curr, 0);
              document.getElementById(document.getElementById('selectModalLabel').value+"Price").textContent = '¥' + priceList[partsCategoryName];
              document.getElementById("totalPrice").textContent = '¥' + totalPrice.toLocaleString();
              document.getElementById("sideTotalPrice").textContent='¥' + totalPrice.toLocaleString();

              if (document.getElementById('selectModalLabel').value == 'CPU') {
                cpuGenFilter = selectPartsList?.[9] != undefined ? selectPartsList?.[9] : '';
              }
              if (document.getElementById('selectModalLabel').value == 'MB') {
                mbChipsetFilter = selectPartsList?.[7] != undefined ? selectPartsList?.[7] : '';
              }

              ////////////////プリセットデータ格納//////////////
              presetDataList[partsCategoryName + "Id"] = selectPartsList[1];
              presetDataList[partsCategoryName + "Name"] = selectPartsList?.[3];
              presetDataList[partsCategoryName + "Url"] = selectPartsList?.[2];
              presetDataList["totalPrice"] = totalPrice;
              
            });
          });
        })
      })

      const cards = document.querySelectorAll('.parts-select-card');
      cards.forEach( async function(card) {
        const partsCategoryName = card.id.toLowerCase();
        const partsCategoryCard = document.getElementById(partsCategoryName);
        let selectPartsList;
        let res;
        if(paramData[1] === null || paramData[1] == 0 || paramData[1] === undefined || paramData === "") {
          selectPartsList = Object.values({
            "id": "",
            "product_id": "",
            "url": "",
            "product_name": "未選択",
            "price": 0,
            "release_date": ""
          });
        }else{
          switch(partsCategoryName.toUpperCase()){
            case 'CPU':
              res = await fetch(`/api/getPresetCpuInfo?preset_id=` + paramData[1]);
              break;
            case 'GPU':
              res = await fetch(`/api/getPresetGpuInfo?preset_id=` + paramData[1]);
              break;
            case 'MEMORY':
              res = await fetch(`/api/getPresetMemoryInfo?preset_id=` + paramData[1]);
              break;
            case 'MB':
              res = await fetch(`/api/getPresetMbInfo?preset_id=` + paramData[1]);
              break;
            case 'SSD':
              res = await fetch(`/api/getPresetSsdInfo?preset_id=` + paramData[1]);
              break;
            case 'PSU':
              res = await fetch(`/api/getPresetPsuInfo?preset_id=` + paramData[1]);
              break;
            case 'OS':
              res = await fetch(`/api/getPresetOsInfo?preset_id=` + paramData[1]);
              break;
          }
          let data=res.json();
              data.then(selectPartsList => {
                if (selectPartsList[0] != null) {
                  selectPartsList = Object.values(selectPartsList[0]);
                  partsCategoryCard.querySelector(".price").textContent = '¥' + selectPartsList?.[4].toLocaleString();
                  partsCategoryCard.querySelector(".name").textContent = selectPartsList?.[3];
                  if (partsCategoryCard.querySelector(".spec1") != null) {
                    partsCategoryCard.querySelector(".spec1").textContent = selectPartsList?.[6];
                  }
                  if (partsCategoryCard.querySelector(".spec2") != null) {
                    partsCategoryCard.querySelector(".spec2").textContent = selectPartsList?.[7];
                  }
                  if (partsCategoryCard.querySelector(".spec3") != null) {
                    partsCategoryCard.querySelector(".spec3").textContent = selectPartsList?.[8];
                  }
                  if (partsCategoryCard.querySelector(".spec4") != null) {
                    partsCategoryCard.querySelector(".spec4").textContent = selectPartsList?.[9];
                  }

                  priceList[partsCategoryName] = selectPartsList?.[4];
                  let totalPrice = Object.values(priceList).reduce((acc, curr) => acc + curr, 0);
                  document.getElementById(partsCategoryName.toUpperCase() + "Price").textContent = '¥' + priceList[partsCategoryName];
                  document.getElementById("totalPrice").textContent = '¥' + totalPrice.toLocaleString();
                  document.getElementById("sideTotalPrice").textContent='¥' + totalPrice.toLocaleString();

                  if (document.getElementById('selectModalLabel').value == 'CPU') {
                    cpuGenFilter = selectPartsList?.[9] != undefined ? selectPartsList?.[9] : '';
                  }
                  if (document.getElementById('selectModalLabel').value == 'MB') {
                    mbChipsetFilter = selectPartsList?.[7] != undefined ? selectPartsList?.[7] : '';
                  }

                  ////////////////プリセットデータ格納//////////////
                  presetDataList[partsCategoryName + "Id"] = selectPartsList[1];
                  presetDataList[partsCategoryName + "Name"] = selectPartsList?.[3];
                  presetDataList[partsCategoryName + "Url"] = selectPartsList?.[2];
                }
              })
        }
      })


      if ( !(paramData[1] === null || paramData[1] == 0 || paramData[1] === undefined || paramData === "") ) {
          fetch('/api/getPresetDescriptionInfo?preset_id=' + paramData[1], {
            method: 'GET',
            headers: { 'Content-Type': 'application/json', },
          })
          .then(res => {
            res.json()
            .then(presetData => {
              if (presetData.length != 0) {
                document.getElementById("description").value = presetData[0].description;
                presetDataList["description"] = presetData[0].description;
                document.getElementById("presetName").value = presetData[0].presetName;
                presetDataList["presetName"] = presetData[0].presetName;
              }
            })
            console.log(res);
          })
      }

      //////プリセット保存/////
      document.getElementById('presetSaveBtn').addEventListener('click', () => {
        presetDataList["presetName"] = document.getElementById("presetName").value;
        presetDataList["description"] = document.getElementById("description").value;
        let totalPrice = Object.values(priceList).reduce((acc, curr) => acc + curr, 0);
        presetDataList["totalPrice"] = totalPrice;
        console.log(presetDataList);
        fetch('/api/presetSave', {
          method: methodType,
          headers: { 'Content-Type': 'application/json', },
          body: JSON.stringify(presetDataList),
        })
        .then(res =>
          console.log(res)
        )
        window.location.href = "/preset-list";
      })

    });
