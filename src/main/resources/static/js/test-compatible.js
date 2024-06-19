'use strict'
    // ボタンクリック時の処理を定義
    document.getElementById('add-btn').addEventListener('click', () => {
        // リクエストで送信するJSON用のオブジェクト作成
        const compatible = {
//          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
            cpuGen: document.getElementById('cpu_gen').value,
            chipset: document.getElementById('chipset').value,
        }
        // POSTでリクエスト送信
        // compatibleをJSONに変換して送る
        fetch('/api/compatible', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(compatible),
        })
        .then(res => console.log(res))
    })
    
    document.getElementById('update-btn').addEventListener('click', () => {
            // リクエストで送信するJSON用のオブジェクト作成
            const compatible = {
    //          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
                compatibleId: document.getElementById('compatible_id').value,
                cpuGen: document.getElementById('cpu_gen').value,
                chipset: document.getElementById('chipset').value,
            }
            // PUTでリクエスト送信
            // compatibleをJSONに変換して送る
            fetch('/api/compatible', {
              method: 'PUT',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(compatible),
            })
            .then(res => console.log(res))
        })


        fetch('/api/compatible', {
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