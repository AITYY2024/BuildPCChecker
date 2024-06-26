window.addEventListener('load', () => {
      let deleteBtn = document.getElementById('deleteBtn');
      deleteBtn.addEventListener('click', function() {
        const deletePresetId = this.getAttribute('data-id');
        console.log(deletePresetId);
        // deletePresetIdをもとにuserを削除するfetchを追加
      });
    });


    const body = {};
    document.getElementById('deleteBtn').addEventListener('click', () => {
    fetch('/api/userDelete', {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        },
             body: JSON.stringify(body)
      });
      window.location.href = '/login-redirect';
    })