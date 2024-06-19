'use strict'

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

//    //プリセット詳細表示
//    fetch('/api/productDetail', {
//      method: 'GET',
//      headers: {
//        'Content-Type': 'application/json',
//      },
//    //  body: JSON.stringify(product),
//    })
//    .then(res => {
//        //データをもっていく必要があるため
//        res.json().then( data => {
//            console.log(data);
//        })
//        console.log(res);
//    })

////プリセット削除
//document.getElementById('delete-btn').addEventListener('click', () => {
//    // リクエストで送信するJSON用のオブジェクト作成
//    const preset = {
////          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
//        presetId: document.getElementById('preset_id').value
//    }
//    // POSTでリクエスト送信
//    // userをJSONに変換して送る
//    fetch('/api/productDelete', {
//      method: 'DELETE',
//      headers: {
//        'Content-Type': 'application/json',
//      },
//      body: JSON.stringify(preset),
//    })
//    .then(res => console.log(res))
//})

////プリセット編集
//document.getElementById('edit-btn').addEventListener('click', () => {
//    // リクエストで送信するJSON用のオブジェクト作成
//    const product = {
//        //Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
//        preset_id: document.getElementById('preset_id').value,//更新はしない値
//        preset_name: document.getElementById('preset_name').value,
//        user_id: document.getElementById('user_id').value,//更新はしない値
//
//        cpu_id: document.getElementById('cpu_id').value,
//        cpu_name: document.getElementById('cpu_name').value,
//        cpu_url: document.getElementById('cpu_url').value,
//
//        gpu_id: document.getElementById('gpu_id').value,
//        gpu_name: document.getElementById('gpu_name').value,
//        gpu_url: document.getElementById('gpu_url').value,
//
//        ram_id: document.getElementById('ram_id').value,
//        ram_name: document.getElementById('ram_name').value,
//        ram_url: document.getElementById('ram_url').value
//
//        mb_id: document.getElementById('mb_id').value,
//        mb_name: document.getElementById('mb_name').value,
//        mb_url: document.getElementById('mb_url').value
//
//        ssd_id: document.getElementById('ssd_id').value,
//        ssd_name: document.getElementById('ssd_name').value,
//        ssd_url: document.getElementById('ssd_url').value
//
//        psu_id: document.getElementById('psu_id').value,
//        psu_name: document.getElementById('psu_name').value,
//        psu_url: document.getElementById('psu_url').value
//
//        os_id: document.getElementById('os_id').value,
//        os_name: document.getElementById('os_name').value,
//        os_url: document.getElementById('os_url').value
//
//        description: document.getElementById('description').value,
//        total_amount: document.getElementById('total_amount').value,
//    }
//
//    // POSTでリクエスト送信
//    // userをJSONに変換して送る
//    fetch('/api/productEdit', {
//      method: 'PUT',
//      headers: {
//        'Content-Type': 'application/json',
//      },
//      //RestControllerで送る際には、product.user_idみたいな形で送らないといけない
//      body: JSON.stringify(product),
//    })
//    .then(res => console.log(res))
//})

////プリセットコピー
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

//プリセット更新
