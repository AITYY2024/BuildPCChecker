document.getElementById('loginForm').addEventListener('submit', function(event) {
  event.preventDefault();
  const userName = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const data = {
    id: 0,
    userName: userName,
    password: password
  }
  fetch('/api/user', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })

  .then(res => {
    if (res.status === 400) {
    } else {
      res.json().then(data => {
      console.log(data);
        if (data === 2) {
            window.location.href = '/parts-select';
        } else if (data === 1){
            window.location.href = '/compatible';
        } else {
            document.getElementById('errorMessage').innerText = 'ユーザー名またはパスワードが間違っています。';
        }
      })
    }
  });
});

document.getElementById('signinForm').addEventListener('submit', function(event) {
  event.preventDefault();
  const userName = document.getElementById('newUsername').value;
  const password = document.getElementById('newPassword').value;
  const data = {
    id: 0,
    userName: userName,
    password: password
  }
  fetch('/api/user', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
});