var http = require('http'); // 웹 서버 역할 수행하는 객체 생성
http.createServer(function (req, res) { // 클라이언트 요청이 들어올 때마다 호출될 함수
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.write('Hello World\n');
  res.write('ohora world\n');
  res.end();
}).listen(8881, '127.0.0.1'); // 클라이언트의 요청 대기 시작(서버 port 번호:1337)

console.log('Server running at http://127.0.0.1:8881/');
