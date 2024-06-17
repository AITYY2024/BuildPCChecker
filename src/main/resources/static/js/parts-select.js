'use strict'
    // ボタンクリック時の処理を定義
    document.getElementById('btn').addEventListener('click', () => {
        // リクエストで送信するJSON用のオブジェクト作成
        const user = {
//          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
            name: document.getElementById('name').value,
            mail: document.getElementById('password').value,
        }
        // POSTでリクエスト送信
        // userをJSONに変換して送る
        fetch('/api/user', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(user),
        })
        .then(res => console.log(res))
    })