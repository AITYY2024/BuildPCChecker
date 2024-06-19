'use strict'
    // ボタンクリック時の処理を定義
    document.getElementById('btn').addEventListener('click', () => {
        // リクエストで送信するJSON用のオブジェクト作成
        const user = {
//          Javaのフォームクラスのフィールド名:document.getElementById('HTMLのID').value
            id: 0,
            user_name: document.getElementById('name').value,
            password: document.getElementById('password').value,
            role: 0
        }
        // POSTでリクエスト送信
        // userをJSONに変換して送る
//        fetch('/api/user', {  //ログインテスト
        fetch('/api/user_insert', {
//          method: 'POST',  //ログインテスト
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(user),
        })
        .then(res => console.log(res))
    })