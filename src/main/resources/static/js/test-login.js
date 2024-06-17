'use strict'
    // ボタンクリック時の処理を定義
    document.getElementById('btn').addEventListener('click', () => {
        // リクエストで送信するJSON用のオブジェクト作成
        const preset = {
//          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
            cpuId: document.getElementById('cpu_id').value,
            cpuName: document.getElementById('cpu_name').value,
            gpuId: document.getElementById('gpu_id').value,
            gpuName: document.getElementById('gpu_name').value,
            ramId: document.getElementById('ram_id').value,
            ramName: document.getElementById('ram_name').value,
            ssdId: document.getElementById('ssd_id').value,
            ssdName: document.getElementById('ssd_name').value,
            psuId: document.getElementById('psu_id').value,
            psuName: document.getElementById('psu_name').value,
            totalAmount: document.getElementById('total_amount').value
        }
        // POSTでリクエスト送信
        // presetをJSONに変換して送る
        fetch('/api/preset', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(preset),
        })
        .then(res => console.log(res))
    })