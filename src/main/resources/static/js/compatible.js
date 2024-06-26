window.addEventListener('load', () => {
  getCompatibleData();

  function getCompatibleData() {
      fetch('/api/compatible', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          },
        //  body: JSON.stringify(product),
        })
        .then(res => {
            res.json().then( gen => {

              fetch('/api/chipset', {
                method: 'GET',
                headers: {
                  'Content-Type': 'application/json',
                },
              //  body: JSON.stringify(product),
              })
              .then(res => {
                  res.json().then( chipset => {
                    console.log(gen);
                    console.log(chipset);

                    setCompatibleDataList(gen, chipset);

                  })
                  console.log(res);
              })

            })
            console.log(res);
        })
  }

  function setCompatibleDataList(data, chipset) {
    const groupedData = {};

    // CPU世代ごとにグループ化
    data.forEach(item => {
      if (!groupedData[item.cpuGeneration]) {
        groupedData[item.cpuGeneration] = [];
      }
      groupedData[item.cpuGeneration].push(item);
    });

    const tableBody = document.getElementById('compatibleList');
    tableBody.innerHTML = '';

    // 各CPU世代に対して行を生成
    for (const cpuGeneration in groupedData) {
      const row = document.createElement('tr');
      const cpuCell = document.createElement('th');
      cpuCell.setAttribute('scope', 'row');
      cpuCell.textContent = cpuGeneration;

      const chipsetCell = document.createElement('td');

      // 各CPU世代のチップセットボタンを生成
      groupedData[cpuGeneration].forEach(item => {
        const badgeSpan = document.createElement('button');
        badgeSpan.setAttribute('type', 'button');
        badgeSpan.classList.add('btn', 'btn-outline-primary', 'chipset-btn', 'fw-semibold', 'border-1', 'rounded-5', 'me-1', 'my-2', 'px-1', 'py-0');
        badgeSpan.textContent = item.chipsetName;
        badgeSpan.setAttribute('data-id', item.id);
        badgeSpan.setAttribute('data-cpugen-name', item.cpuGeneration);
        badgeSpan.setAttribute('data-chipset-name', item.chipsetName);
        badgeSpan.setAttribute('data-bs-toggle', 'modal');
        badgeSpan.setAttribute('data-bs-target', '#deleteModal');

        // ボタンクリック時のイベントリスナー
        badgeSpan.addEventListener('click', (event) => {
          const deleteCpuGenName = event.currentTarget.getAttribute('data-cpugen-name');
          document.getElementById('deleteCpuGenName').textContent = deleteCpuGenName;
          const deleteMbChipsetName = event.currentTarget.getAttribute('data-chipset-name');
          document.getElementById('deleteMbChipsetName').textContent = deleteMbChipsetName;
          const compatibleId = event.currentTarget.getAttribute('data-id');
          document.getElementById('deleteBtn').setAttribute('data-id', compatibleId);
        });
        chipsetCell.appendChild(badgeSpan);
      });

      const addBtnCell = document.createElement('td');
      const addBtn = document.createElement('button');
      addBtn.classList.add('btn', 'btn-sm', 'btn-primary', 'mt-1');
      addBtn.setAttribute('type', 'button');
      addBtn.setAttribute('data-bs-toggle', 'modal');
      addBtn.setAttribute('data-bs-target', '#selectModal');

      const chipsetList = document.getElementById('chipsetList');
      const chipsetCard =`
        <div class="col-sm-6 col-md-3">
          <div class="card my-2 border-primary-subtle border-3 chipset-card" data-bs-dismiss="modal">
            <div class="card-body border border-0 py-3 list-group-item list-group-item-action" aria-current="true">
              <div class="d-flex w-100 justify-content-center">
                <h6 class="mb-0 name"></h6>
              </div>
            </div>
          </div>
        </div>`;

      addBtn.addEventListener('click', (event) => {
        document.getElementById('selectModalHeader').textContent = cpuGeneration + 'に対応するチップセットを選択';
        const addedChipset = data.filter(item => item.cpuGeneration === cpuGeneration).map(item => item.chipsetName);
        document.getElementById('selectModal').setAttribute('data-cpugen-name', cpuGeneration);
        chipsetList.innerHTML = '';
        chipset.forEach( (item, index) => {
          chipsetList.insertAdjacentHTML('beforeend', chipsetCard);
          chipsetList.querySelectorAll('.name')[index].textContent = item;
          if (!addedChipset.includes(item)) {
            chipsetList.querySelectorAll('.chipset-card')[index].setAttribute('data-chipset-name', item);
            chipsetList.querySelectorAll('.chipset-card')[index].addEventListener('click', (event) => {
                const cpuGen = document.getElementById('selectModal').getAttribute('data-cpugen-name');
                const chipset = event.currentTarget.getAttribute('data-chipset-name');
                console.log(cpuGen + ' / ' + chipset);

                const addData = { 'compatibleId': 0, 'cpuGen': cpuGen, 'chipset': chipset };

                fetch('/api/compatible', {
                  method: 'POST',
                  headers: {
                    'Content-Type': 'application/json',
                  },
                  body: JSON.stringify(addData),
                })
                .then(res => {
                    console.log(res);
                    getCompatibleData();
                })

            });
          } else {
            chipsetList.querySelectorAll('.name')[index].classList.add('text-secondary');
            chipsetList.querySelectorAll('.chipset-card')[index].classList.remove('border-primary-subtle');
            chipsetList.querySelectorAll('.chipset-card')[index].classList.add('border-secondary-subtle');
            chipsetList.querySelectorAll('.list-group-item')[index].classList.remove('list-group-item-action');
            chipsetList.querySelectorAll('.chipset-card')[index].removeAttribute('data-bs-dismiss');
          }
        });
      });

      addBtn.textContent = '追加';

      addBtnCell.appendChild(addBtn);
      row.appendChild(cpuCell);
      row.appendChild(chipsetCell);
      row.appendChild(addBtnCell);
      tableBody.appendChild(row);
    }
  }

  const deleteBtn = document.getElementById('deleteBtn');
  deleteBtn.addEventListener('click', (event) => {
    const deleteId = event.currentTarget.getAttribute('data-id');
    console.log(deleteId);

    fetch('/api/compatible', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(deleteId),
    })
    .then(res => {
        console.log(res);
        getCompatibleData();
    })

  });

});