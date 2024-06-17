'use strict'
    // ボタンクリック時の処理を定義
    document.getElementById('btn').addEventListener('click', () => {
        // リクエストで送信するJSON用のオブジェクト作成
//        const user = {}
        // POSTでリクエスト送信
        // presetをJSONに変換して送る
        fetch('/api/user', {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json',
          },
          body: null,
        })
        .then(res => console.log(res))
    })