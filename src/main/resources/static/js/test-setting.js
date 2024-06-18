'use strict'
    // ボタンクリック時の処理を定義
    document.getElementById('btn').addEventListener('click', () => {
        // リクエストで送信するJSON用のオブジェクト作成
//        const user = {}
        // DELETEリクエスト送信(@DeleteMappingで受け取る)
        // JSONに変換して送る
        fetch('/api/userDelete', {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json',
          },
          body: null,
        })
        .then(res => console.log(res))
    })