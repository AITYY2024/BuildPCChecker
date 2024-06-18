'use strict'

//document.getElementById('copy-btn').addEventListener('click', () => {
//    // リクエストで送信するJSON用のオブジェクト作成
//    const product = {
////          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
//        cpuId: document.getElementById('cpu_id').value,
//        cpuName: document.getElementById('cpu_name').value,
//        gpuId: document.getElementById('gpu_id').value,
//        gpuName: document.getElementById('gpu_name').value,
//        ramId: document.getElementById('ram_id').value,
//        ramName: document.getElementById('ram_name').value,
//        ssdId: document.getElementById('ssd_id').value,
//        ssdName: document.getElementById('ssd_name').value,
//        psuId: document.getElementById('psu_id').value,
//        psuName: document.getElementById('psu_name').value,
//        totalAmount: document.getElementById('total_amount').value,
//        presetName: document.gtElementById('preset_name').value
//    }
//    // POSTでリクエスト送信
//    // userをJSONに変換して送る
//    fetch('/api/productEdit', {
//      method: 'POST',
//      headers: {
//        'Content-Type': 'application/json',
//      },
//      body: JSON.stringify(product),
//    })
//    .then(res => console.log(res))
//})

//削除
document.getElementById('delete-btn').addEventListener('click', () => {
    // リクエストで送信するJSON用のオブジェクト作成
    const preset = {
//          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
        presetId: document.getElementById('preset_id').value
    }
    // POSTでリクエスト送信
    // userをJSONに変換して送る
    fetch('/api/productDelete', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(preset),
    })
    .then(res => console.log(res))
})

//document.getElementById('edit-btn').addEventListener('click', () => {
//    // リクエストで送信するJSON用のオブジェクト作成
//    const product = {
////          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
//        cpuId: document.getElementById('cpu_id').value,
//        cpuName: document.getElementById('cpu_name').value,
//        gpuId: document.getElementById('gpu_id').value,
//        gpuName: document.getElementById('gpu_name').value,
//        ramId: document.getElementById('ram_id').value,
//        ramName: document.getElementById('ram_name').value,
//        ssdId: document.getElementById('ssd_id').value,
//        ssdName: document.getElementById('ssd_name').value,
//        psuId: document.getElementById('psu_id').value,
//        psuName: document.getElementById('psu_name').value,
//        totalAmount: document.getElementById('total_amount').value,
//        presetName: document.getElementById('preset_name').value
//    }

//    // POSTでリクエスト送信
//    // userをJSONに変換して送る
//    fetch('/api/productEdit', {
//      method: 'POST',
//      headers: {
//        'Content-Type': 'application/json',
//      },
//      body: JSON.stringify(product),
//    })
//    .then(res => console.log(res))
//})

    // プリセット一覧表示
    // POSTでリクエスト送信
    // userをJSONに変換して送る
    fetch('/api/product', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    //  body: JSON.stringify(product),
    })
    .then(res => {
        //データをもっていく必要があるため
        res.json().then( data => {
            console.log(data);
        })
        console.log(res);
    })