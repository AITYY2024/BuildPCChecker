//'use strict'
    window.addEventListener('load', () => {
      //テストデータ
      const cpu = [
        {"product_id": "K0001603514", "url": "https://kakaku.com/item/K0001603514/", "product_name": "AMD Ryzen 5 5500GT BOX", "price": 16978, "release_date": "2024-02-02", "core": "6C/12T", "freq": "3.6GHz", "socket": "SocketAM4", "gen": "Ryzen 5000シリーズ"},
        {"product_id": "K0001577323", "url": "https://kakaku.com/item/K0001577323/", "product_name": "インテル Core i7 14700K BOX", "price": 63498, "release_date": "2023-10-17", "core": "20C/28T", "freq": "3.4GHz", "socket": "LGA1700", "gen": "第14世代 Core プロセッサー"},
        {"product_id": "K0001507442", "url": "https://kakaku.com/item/K0001507442/", "product_name": "AMD Ryzen 9 7950X3D BOX", "price": 88480, "release_date": "2023-01-06", "core": "16C/32T", "freq": "4.2GHz", "socket": "SocketAM5", "gen": "Ryzen 7000シリーズ"}
      ];

      const gpu = [
        {"product_id": "K0001507103", "url": "https://kakaku.com/item/K0001507103/", "product_name": "ASUS TUF-RTX4070TI-12G-GAMING ", "price": 119980, "release_date": "2023-01-06", "chip": "NVIDIA GeForce RTX 4070 Ti", "vram": "GDDR6X 12GB"},
        {"product_id": "K0001391662", "url": "https://kakaku.com/item/K0001391662/", "product_name": "ASRock Radeon RX 6600 Challenger D 8GB ", "price": 30670, "release_date": "2021-10-14", "chip": "AMD Radeon RX 6600", "vram": "GDDR6 8GB"},
        {"product_id": "K0001601431", "url": "https://kakaku.com/item/K0001601431/", "product_name": "Palit Microsystems NED4090019SB-1020Q (GeForce RTX 4090 GameRock OmniBlack 24GB)  ドスパラ限定モデル", "price": 279800, "release_date": "2024-01-25", "chip": "NVIDIA GeForce RTX 4090", "vram": "GDDR6X 24GB"}
      ];

      const memory = [
        {"product_id": "K0001540695", "url": "https://kakaku.com/item/K0001540695/", "product_name": "crucial CP2K16G4DFRA32A ", "price": 8970, "release_date": "2023-05-30", "capacity": "16GB", "count": "2枚", "spec": "DDR4"},
        {"product_id": "K0001579727", "url": "https://kakaku.com/item/K0001579727/", "product_name": "crucial CP2K32G56C46U5 ", "price": 29000, "release_date": "2023-10-26", "capacity": "32GB", "count": "2枚", "spec": "DDR5"},
        {"product_id": "K0001540696", "url": "https://kakaku.com/item/K0001540696/", "product_name": "crucial CP2K32G4DFRA32A ", "price": 18381, "release_date": "2023-05-30", "capacity": "32GB", "count": "2枚", "spec": "DDR4"}
      ];

      const mb = [
        {"product_id": "K0001475577", "url": "https://kakaku.com/item/K0001475577/", "product_name": "ASUS ROG STRIX X670E-A GAMING WIFI", "price": 47455, "release_date": "2022-09-30", "formfactor": "ATX", "chipset": "AMD X670E", "socket": "SocketAM5", "ram_spec": "DDR5"},
        {"product_id": "K0001492978", "url": "https://kakaku.com/item/K0001492978/", "product_name": "ASRock Z790 Pro RS WiFi", "price": 25980, "release_date": "2022-11-18", "formfactor": "ATX", "chipset": "INTEL Z790", "socket": "LGA1700", "ram_spec": "DDR5"},
        {"product_id": "K0001570277", "url": "https://kakaku.com/item/K0001570277/", "product_name": "MSI B650 GAMING PLUS WIFI", "price": 20557, "release_date": "2023-09-22", "formfactor": "ATX", "chipset": "AMD B650", "socket": "SocketAM5", "ram_spec": "DDR5"}
      ];

      const ssd = [
        {"product_id": "K0001467995", "url": "https://kakaku.com/item/K0001467995/", "product_name": "WESTERN DIGITAL WD_Black SN850X NVMe SSD WDS200T2X0E", "price": 24400, "release_date": "2022-08-31", "capacity": "2000GB", "spec_size": "M.2 (Type2280)", "interface": "PCIe Gen4"},
        {"product_id": "K0001028334", "url": "https://kakaku.com/item/K0001028334/", "product_name": "crucial MX500 CT500MX500SSD1/JP", "price": 6880, "release_date": "2018-01-25", "capacity": "500GB", "spec_size": "2.5インチ", "interface": "SATA 6Gb/s"},
        {"product_id": "K0001424274", "url": "https://kakaku.com/item/K0001424274/", "product_name": "WESTERN DIGITAL WD_Black SN770 NVMe WDS100T3X0E", "price": 12880, "release_date": "2022-02-28", "capacity": "1000GB", "spec_size": "M.2 (Type2280)", "interface": "PCIe Gen4"}
      ]

      const psu = [
        {"product_id": "K0001607594", "url": "https://kakaku.com/item/K0001607594/", "product_name": "MSI MAG A650BNL", "price": 6910, "release_date": "2024-02-20", "capacity": "650W", "formfactor": "ATX", "spec_80plus": "BRONZE"},
        {"product_id": "K0001530355", "url": "https://kakaku.com/item/K0001530355/", "product_name": "NZXT C1200 Gold PA-2G1BB-JP", "price": 17074, "release_date": "2023-04-18", "capacity": "1200W", "formfactor": "ATX12V v3.0/EPS12V v2.92", "spec_80plus": "GOLD"},
        {"product_id": "K0001530839", "url": "https://kakaku.com/item/K0001530839/", "product_name": "Corsair RM850e ATX 3.0 CP-9020263-JP", "price": 15695, "release_date": "2023-04-21", "capacity": "850W", "formfactor": "ATX 3.0", "spec_80plus": "GOLD"}
      ];

      const os = [
        {"product_id": "K0001432816", "url": "https://kakaku.com/item/K0001432816/", "product_name": "マイクロソフト Windows 11 Home 日本語版", "price": 15990, "release_date": "2022-04-01"},
        {"product_id": "K0001432814", "url": "https://kakaku.com/item/K0001432814/", "product_name": "マイクロソフト Windows 11 Pro 日本語版", "price": 21750, "release_date": "2022-04-01"},
        {"product_id": "K0001027613", "url": "https://kakaku.com/item/K0001027613/", "product_name": "マイクロソフト Windows 10 Home 64bit 日本語 DSP版", "price": 12980, "release_date": "2018-01-22"}
      ];

      let priceList = {"cpu": 0, "gpu": 0, "memory": 0, "mb": 0, "ssd": 0, "psu": 0, "os": 0};

//////URLのパラメータ受け取り//////
      let param = location.search.substring(1).split('&');
      paramData = param[0].split('=');

      let presetDataList = {
        "presetId": paramData[1],   //値が入っていなければ新規判定
        "presetName": "",
        "cpuId":    0, "cpuName":    0, "cpuUrl":    0,
        "gpuId":    0, "gpuName":    0, "gpuUrl":    0,
        "memoryId": 0, "memoryName": 0, "memoryUrl": 0,
        "mbId":     0, "mbName":     0, "mbUrl":     0,
        "ssdId":    0, "ssdName":    0, "ssdUrl":    0,
        "psuId":    0, "psuName":    0, "psuUrl":    0,
        "osId":     0, "osName":     0, "osUrl":     0,
        "description": "",
        "totalPrice":0
      };

//////////モーダル表示///////////
      const selectButtons = document.querySelectorAll('button[data-bs-toggle="modal"]');
      selectButtons.forEach(button => {
        button.addEventListener('click', (event) => {
          const partsCategoryName = event.currentTarget.getAttribute('data-name');
          document.getElementById('selectModalLabel').setAttribute('data-name', partsCategoryName);
          const partsList = document.getElementById('partsList');
          partsList.innerHTML = '';

          let data;
          let selectModalTitle;
          switch (partsCategoryName) {
            case 'CPU':
              selectModalTitle = 'CPU';
              data = cpu;
              break;
            case 'GPU':
              selectModalTitle = 'グラフィックボード';
              data = gpu;
              break;
            case 'MEMORY':
              selectModalTitle = 'メモリ';
              data = memory;
              break;
            case 'MB':
              selectModalTitle = 'マザーボード';
              data = mb;
              break;
            case 'SSD':
            selectModalTitle = 'SSD';
              data = ssd;
              break;
            case 'PSU':
              selectModalTitle = '電源';
              data = psu;
              break;
            case 'OS':
              selectModalTitle = 'OS';
              data = os;
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
                // console.log(dataId);

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

                presetDataList[partsCategoryName + "Id"] = selectPartsList[0];
                presetDataList[partsCategoryName + "Name"] = selectPartsList?.[2];
                presetDataList[partsCategoryName + "Url"] = selectPartsList?.[1];

                //メモと合計金額とプリセット名をプリセットデータに入れる
                presetDataList["description"] = document.getElementById("description").value;
                presetDataList["totalPrice"] = totalPrice;
                presetDataList["presetName"] = document.getElementById("presetName").value;

                console.log(presetDataList);
              });
            });

          }
        });
      });

    });