'use strict'
        window.addEventListener('load', () => {
          let priceList = {"cpu": 0, "gpu": 0, "memory": 0, "mb": 0, "ssd": 0, "psu": 0, "os": 0};

    //////URLのパラメータ受け取り//////
          let param = location.search.substring(1).split('&');
          paramData = Number(param[0].split('='));

    //////Javaに送信するオブジェクト//////
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
            //button.addEventListener('click', async function(event) => {
            button.addEventListener('click', async function(event){
              const partsCategoryName = event.currentTarget.getAttribute('data-name');
              document.getElementById('selectModalLabel').setAttribute('data-name', partsCategoryName);
              const partsList = document.getElementById('partsList');
              partsList.innerHTML = '';

              let data;
              let selectModalTitle;

              switch (partsCategoryName) {
                case 'CPU':
                  selectModalTitle = 'CPU';
                  data = await fetch(`/api/getCpuList`);
                  break;
                case 'GPU':
                  selectModalTitle = 'グラフィックボード';
                  data = await fetch(`/api/getGpuList`);
                  break;
                case 'MEMORY':
                  selectModalTitle = 'メモリ';
                  data = await fetch(`/api/getRamList`);
                  break;
                case 'MB':
                  selectModalTitle = 'マザーボード';
                  data = await fetch(`/api/getMbList`);
                  break;
                case 'SSD':
                selectModalTitle = 'SSD';
                  data = await fetch(`/api/getSsdList`);
                  break;
                case 'PSU':
                  selectModalTitle = '電源';
                  data = await fetch(`/api/getPsuList`);
                  break;
                case 'OS':
                  selectModalTitle = 'OS';
                  data = await fetch(`/api/getOsList`);
                  break;
              }
              document.getElementById('selectModalLabel').textContent = selectModalTitle + 'を選択';

              let dataObj;
              for (let i = 0; i < data.length; i++) {
                dataObj = Object.values(data[i]);
                partsCard = `
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
                  </div>`
                partsList.insertAdjacentHTML('beforeend', partsCard);

                partsList.querySelectorAll('.parts-card')[i].setAttribute('data-id', dataObj?.[0]);
                partsList.querySelectorAll(".name")[i].textContent = dataObj?.[2];
                partsList.querySelectorAll(".price")[i].textContent = '¥' + dataObj?.[3].toLocaleString();
                if (partsList.querySelectorAll(".spec1")[i] != null) {
                  partsList.querySelectorAll(".spec1")[i].textContent = dataObj?.[5];
                }
                if (partsList.querySelectorAll(".spec2")[i] != null) {
                  partsList.querySelectorAll(".spec2")[i].textContent = dataObj?.[6];
                }
                if (partsList.querySelectorAll(".spec3")[i] != null) {
                  partsList.querySelectorAll(".spec3")[i].textContent = dataObj?.[7];
                }
                if (partsList.querySelectorAll(".spec4")[i] != null) {
                  (partsList.querySelectorAll(".spec4")[i].textContent = dataObj?.[8]);
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
                method: methodType,
                headers: {
               'Content-Type': 'application/json',
             },
             body: JSON.stringify(presetDataList),
            })
           .then(res =>
               console.log(res)
               )
        })

});