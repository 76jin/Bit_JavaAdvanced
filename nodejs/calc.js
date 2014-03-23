var http = require('http'); // 웹 서버 역할 수행하는 객체 생성
http.createServer(function (req, res) { // 클라이언트 요청이 들어올 때마다 호출될 함수(requestListener)
  console.log(req.url);
  var urlObj = require('url').parse(req.url, true);
  var pathname = urlObj.pathname;
  var params = urlObj.query;
  
  try {
    if (pathname == '/calc') {
      var result = 0;
      var a = Number(params.a);
      var b = Number(params.b);
      if (params.op == 'plus') {
        result = a + b;
      } else if (params.op == 'minus') {
        result = a - b;
      } else {
        result = '지원하지 않는 연산자이거나 또는 값이 옳지 않습니다.';
      }
    
      // 응답할 때 status: 200 OK, 웹브라우저에게 알려줄 정보 - text/plain이고, 문자셋은 UTF-8임을 알림.
      res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
      res.write('result: ' + String(result)); // 응답 끝났다고 알림.
    }
  } catch (err) {
    res.write(String(err));
  }
  
  res.end();
}).listen(8882, '192.168.200.82'); // 클라이언트의 요청 대기 시작(서버 port 번호:1337)

console.log('Server running at http://127.0.0.1:8882/');
