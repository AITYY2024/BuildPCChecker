var seconds = 2;
var timer;
timer = setInterval(function () {
  document.getElementById("Count").innerHTML = seconds;
  seconds--;
  if (seconds == -1) {
    clearInterval(timer);
    document.location.href = '/login';
  }
}, 1000);