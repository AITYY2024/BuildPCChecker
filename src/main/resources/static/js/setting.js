const header = document.getElementById('header');
header.innerHTML = `
  <div class="bg-body-tertiary d-flex justify-content-between align-items-center p-2" id="defaultNav">
    <span class="mb-0 me-2 h5">Build PC Checker</span>
    <div class="d-none d-sm-flex">
      <a class="nav-link ms-4" href="/parts-select">構成</a>
      <a class="nav-link ms-4" href="/preset-list">プリセット</a>
    </div>
    <div class="btn-group ms-auto">
      <button type="button" class="btn btn-outline-primary" onclick="location.href='/login-redirect'">ログアウト</button>
      <button type="button" class="btn btn-outline-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false"></button>
      <ul class="dropdown-menu dropdown-menu-end">
        <li><a class="dropdown-item" href="javascript:void(0);" id="themeBtn">カラーモード<i class="fa-regular fa-sun ms-2"></i></a></li>
        <li><a class="dropdown-item" href="/setting">アカウント</a></li>
      </ul>
    </div>
  </div>
  <div class="bg-body-tertiary d-sm-none p-2 ps-3" id="mobileNav">
    <div class="d-flex justify-content-start">
      <a class="nav-link" href="/parts-select">構成</a>
      <a class="nav-link ms-4 border-bottom border-2 border-primary fw-semibold" href="/preset-list">プリセット</a>
    </div>
  </div>`;

// ナビゲーションバーの上部固定切り替え
function setDefaultNavFixed() {
  let defaultNav = document.getElementById('defaultNav');
  if (window.innerWidth <= 576) {
    defaultNav.classList.remove('fixed-top');
  } else {
    defaultNav.classList.add('fixed-top');
  }
}

// 小さい画面用ナビゲーションバーの上部固定切り替え
function setMobileNavFixed() {
  let mobileNav = document.getElementById('mobileNav');
  if (window.scrollY >= 53.6) {
    mobileNav.classList.add('fixed-top');
  } else {
    mobileNav.classList.remove('fixed-top');
  }
}

// コンテンツがナビゲーションバーに被らないようにマージン調整
function setMainMargin() {
  let defaultNav = document.getElementById('defaultNav');
  let mobileNav = document.getElementById('mobileNav');
  let main = document.querySelector('.main');
  let navHeight = 0;
  if (window.innerWidth <= 576) {
    if (window.scrollY >= 53.6) {
      navHeight = mobileNav.offsetHeight;
    } else {
      navHeight = 0;
    }
  } else {
    navHeight = defaultNav.offsetHeight;
  }
  main.style.marginTop = navHeight + 10 + 'px';
}

// ウィンドウリサイズ時に実行
window.addEventListener('resize', () => {
  setDefaultNavFixed();
  setMainMargin();
});

// スクロール時に実行
document.addEventListener('scroll', () => {
  setMobileNavFixed();
  setMainMargin();
});

// ロード時に実行
window.addEventListener('load', () => {
  setDefaultNavFixed();
  setMobileNavFixed();
  setMainMargin();
});

// テーマ切り替え
function toggleTheme() {
  const currentTheme = document.documentElement.dataset.bsTheme;
  const newTheme = currentTheme === 'light' ? 'dark' : 'light';
  document.documentElement.dataset.bsTheme = newTheme;
  const themeBtnIcon = document.getElementById("themeBtn").querySelector('i');
  themeBtnIcon.classList.remove(currentTheme === 'light' ? 'fa-sun' : 'fa-moon');
  themeBtnIcon.classList.add(newTheme === 'light' ? 'fa-sun' : 'fa-moon');
}

// ボタン押下時に実行
document.getElementById("themeBtn").addEventListener('click', () => {
  toggleTheme();
});
</script>

<div class="container-sm main">
<div class="card">
    <div class="card-body">
        <h4 class="card-title mb-3">アカウント</h4>
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title mb-2">現在ログイン中のユーザー</h4>
                        <h5 class="card-text mt-3 mb-1">[[${session.sessionUser.userName}]]</h5> <!--user.id-->
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title mb-2">アカウントの削除</h4>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                            削除
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- モーダル -->
<div class="modal fade" id="deleteModal" data-bs-backdrop="static" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
<div class="modal-dialog modal-dialog-centered modal-md">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title">確認</h5>
        </div>
        <div class="modal-body">
            現在ログイン中のユーザー [[${session.sessionUser.userName}]] を削除しますか？ <!--user.id-->
        </div>
        <div class="modal-footer d-block">
            <div class="row m-0 p-0">
                <div class="col ps-0 pe-1">
                    <button type="button" class="btn w-100 btn-secondary" data-bs-dismiss="modal">
                        閉じる
                    </button>
                </div>
                <div class="col ps-1 pe-0">
                    <button type="button" id="deleteBtn" class="btn w-100 btn-danger" data-bs-dismiss="modal" data-id="${session.user.id}"> <!-- data-id=${session.user.id} -->
                        削除
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script>
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