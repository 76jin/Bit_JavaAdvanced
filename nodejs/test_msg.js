var http = require('http');
var totalMsg = [];
http.createServer( function(req, res) {
  try {
    var params = require('url').parse(req.url, true).query;
    totalMsg.push(params.me + ':' + params.msg);
    
    res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
    
    totalMsg.forEach(function(item) {
      res.write(String(item) + '\n');
    });
  } catch (err) {
    res.write(String(err));
  }
  
  res.end();
}).listen(8884, '192.168.200.82');

console.log('Ranian server!!');

