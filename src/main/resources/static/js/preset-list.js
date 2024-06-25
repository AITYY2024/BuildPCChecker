window.addEventListener('load', async function(){
    //presetデータ取得
    presetReload();

    //presetデータ一覧表示
    function setPresetData(data) {
      const presetList = document.getElementById('presetList');
      presetList.innerHTML='';
      for (let i = 0; i < data.length; i++) {
        presetCard = `
          <div class="col-xs-12 col-md-6 col-xl-4">
            <div class="card my-2 preset-card">
              <div class="card-body pb-0">
                <h5 class="card-title"><span class="name"></span><span class="float-end text-danger price"></span>
                </h5>
                <p class="card-text">
                  <div class="row">
                    <div class="col-9 pe-1">
                      <button type="button" class="btn btn-sm btn-primary w-100 detail" data-bs-toggle="modal" data-bs-target="#detailModal">
                        詳細
                      </button>
                    </div>
                    <div class="col-3 ps-1">
                      <button type="button" class="btn btn-sm btn-danger w-100 delete" data-bs-toggle="modal" data-bs-target="#deleteModal">
                        削除
                      </button>
                    </div>
                  </div>
                </p>
              </div>
            </div>
          </div>`
        presetList.insertAdjacentHTML('beforeend', presetCard);

        presetList.querySelectorAll('.detail')[i].setAttribute('data-id', data[i].preset_id);
        presetList.querySelectorAll('.detail')[i].setAttribute('data-name', data[i].preset_name);
        presetList.querySelectorAll('.delete')[i].setAttribute('data-id', data[i].preset_id);
        presetList.querySelectorAll('.delete')[i].setAttribute('data-name', data[i].preset_name);
        presetList.querySelectorAll(".name")[i].textContent = data[i].preset_name;
        presetList.querySelectorAll(".price")[i].textContent = data[i].total_amount.toLocaleString('ja-JP', {style:'currency', currency: 'JPY'}).replace('￥', '¥');
      }

      //////詳細モーダル表示/////
      const detailModalButtons = document.querySelectorAll('button[data-bs-target="#detailModal"]');

      const deleteBtn = document.getElementById('deleteBtn');
      const editBtn = document.getElementById('editBtn');
      const copyBtn = document.getElementById('copyBtn');

      detailModalButtons.forEach(button => {
        button.addEventListener('click', (event) => {
          const presetName = event.currentTarget.getAttribute('data-name');
          document.getElementById('selectModalLabel').textContent = presetName;
          
          const presetId = event.currentTarget.getAttribute('data-id');
          deleteBtn.setAttribute('data-id', presetId);
          editBtn.setAttribute('data-id', presetId);
          copyBtn.setAttribute('data-id', presetId);
          
          document.getElementById('deletePresetName').textContent = presetName;
          const selectPartsList = data.find(item => item.preset_id === Number(presetId));
          const presetDataList = document.getElementById('presetDataList');
          
          document.getElementById('cpuName').textContent = selectPartsList.cpu_name;
          document.getElementById('gpuName').textContent = selectPartsList.gpu_name;
          document.getElementById('memoryName').textContent = selectPartsList.ram_name;
          document.getElementById('mbName').textContent = selectPartsList.mb_name;
          document.getElementById('ssdName').textContent = selectPartsList.ssd_name;
          document.getElementById('psuName').textContent = selectPartsList.psu_name;
          document.getElementById('osName').textContent = selectPartsList.os_name;
          document.getElementById('totalPrice').textContent = selectPartsList.total_amount.toLocaleString('ja-JP', {style:'currency', currency: 'JPY'}).replace('￥', '¥');
          document.getElementById("cpuUrl").href = selectPartsList.cpu_url;
          document.getElementById("gpuUrl").href = selectPartsList.gpu_url;
          document.getElementById("memoryUrl").href = selectPartsList.ram_url;
          document.getElementById("mbUrl").href = selectPartsList.mb_url;
          document.getElementById("ssdUrl").href = selectPartsList.ssd_url;
          document.getElementById("psuUrl").href = selectPartsList.psu_url;
          document.getElementById("osUrl").href = selectPartsList.os_url;
        //   document.getElementById("updateAt").value = '最終更新：'+selectPartsList.update_at;
        });
      });

        //deleteBtnにデータタグ挿入
      const deleteModalButtons = document.querySelectorAll('.delete');
      deleteModalButtons.forEach(button => {
        button.addEventListener('click', (event) => {
          const presetId = event.currentTarget.getAttribute('data-id');
          deleteBtn.setAttribute('data-id', presetId);
          const presetName = event.currentTarget.getAttribute('data-name');
          document.getElementById('deletePresetName').textContent = presetName;
        });
      });

      ////比較////
      let preset1Price = 0;
      let preset2Price = 0;
      let sum = 0

      const selectPreset1Name = document.getElementById('preset1');
      const selectPreset2Name = document.getElementById('preset2');
      const presetPriceSum = document.getElementById('sumPrice');

      for (let i = 0; i < data.length; i++) {
        selectPreset1Name.remove(i);
      }
      
      for (let i = 0; i < data.length; i++) {
        const option = document.createElement('option');
        option.value = data[i].preset_id;
        option.setAttribute('data-price', data[i].total_amount);
        option.textContent = data[i].preset_name;
        selectPreset1Name.appendChild(option);
      }

      selectPreset1Name.addEventListener('change', function() {
        selectPreset2Name.innerHTML = '';
        if (this.value === '') {
          selectPreset2Name.disabled = true;
          presetPriceSum.classList.add('text-primary');
          presetPriceSum.classList.remove('text-danger');
          presetPriceSum.textContent = "選択してください";
        } else {
          selectPreset2Name.disabled = false;
          for (let i = 0; i < data.length; i++) {
            if (data[i].preset_id != this.value) {
              const option = document.createElement('option');
              option.value = data[i].preset_id;
              const presetId = option.setAttribute('data-price', data[i].total_amount);
              option.textContent = data[i].preset_name;
              selectPreset2Name.appendChild(option);
            }
          }
          preset1Price = this.options[this.selectedIndex].getAttribute('data-price');
          preset2Price = selectPreset2Name.options[selectPreset2Name.selectedIndex].getAttribute('data-price');
          sum = Number(preset1Price) - Number(preset2Price);
          presetPriceSum.textContent = sum.toLocaleString('ja-JP', {style:'currency', currency: 'JPY'}).replace('￥', '¥');
          if (sum <= 0) {
            presetPriceSum.classList.add('text-danger');
            presetPriceSum.classList.remove('text-primary');
          } else {
            presetPriceSum.classList.add('text-primary');
            presetPriceSum.classList.remove('text-danger');
          }
        }

      });

    
      selectPreset2Name.addEventListener('change', function() {
        preset1Price = selectPreset1Name.options[selectPreset1Name.selectedIndex].getAttribute('data-price');
        preset2Price = this.options[this.selectedIndex].getAttribute('data-price');
        sum = Number(preset1Price) - Number(preset2Price);
        presetPriceSum.textContent = sum.toLocaleString('ja-JP', {style:'currency', currency: 'JPY'}).replace('￥', '¥');
        if (sum <= 0) {
          presetPriceSum.classList.add('text-danger');
          presetPriceSum.classList.remove('text-primary');
        } else {
          presetPriceSum.classList.add('text-primary');
          presetPriceSum.classList.remove('text-danger');
        }
      });

    }

    ////削除////
    deleteBtn.addEventListener('click', async function() {
      const deletePresetId = this.getAttribute('data-id');
      //テストする
      await fetch('/api/presetDelete', {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(deletePresetId),
      })
      .then(res => {
        console.log(res)
      })
      presetReload();
      
    });

    ////データ編集////
    editBtn.addEventListener('click', function() {
      const editPresetId = this.getAttribute('data-id');
      //テストする
      window.location.href = "/parts-select?presetId="+editPresetId;
    })

    ////データ複製////
    copyBtn.addEventListener('click', async function() {
      const copyPresetId = this.getAttribute('data-id');
      //テストする
      await fetch('/api/presetCopy', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(copyPresetId),
      })
      .then(res => {
        //cards更新
        console.log(res)
      })

      //presetデータ取得
      presetReload();
    });

    async function presetReload(){
      //presetデータ取得
      let res=await fetch('/api/presetList');
      let dataList=res.json();
      dataList.then(data=>{
          setPresetData(data);
      });
    }
  })