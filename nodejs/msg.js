var http = require('http'); // 웹 서버 역할 수행하는 객체 생성(http 모듈-도구함 로딩)
var totalMsg = [];
http.createServer(function (req, res) { // 클라이언트 요청이 들어올 때마다 호출될 함수(requestListener)
  
  // req = me=okok&msg=ohora
  try {
    var params = require('url').parse(req.url, true).query;
    console.log('111',require('url'));
    console.log('222',req.url);
    totalMsg.push(params.me + ':' + params.msg);
    
    // 응답할 때 status: 200 OK, 웹브라우저에게 알려줄 정보 - text/plain이고, 문자셋은 UTF-8임을 알림.
    res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
    
    totalMsg.forEach(function(item) {
      res.write(String(item) + '\n');
    });
  } catch (err) {
    res.write(String(err));
  }
  
  res.end();
}).listen(8883, '192.168.200.82'); // 클라이언트의 요청 대기 시작(서버 port 번호:1337)

console.log('Server running at http://192.168.200.82:8883/');
