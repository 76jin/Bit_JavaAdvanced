var http = require('http'); // 웹 서버 역할 수행하는 객체 생성(http 모듈-도구함 로딩)

var twitterAPI = require('node-twitter-api');
var twitter = new twitterAPI({
    consumerKey: 'KHL2TatWdI1izPKY4qm52w',                        // API key
    consumerSecret: 'xMxWld20Ouzww2LUY2smC22eEeunTCLHYWrnZ3jNSg', // API Secret Key
    callback: 'http://s24.java48.com:8884/getAccessToken'         // 로그인 성공 후 자동 접속할 주소
});

var reqToken, reqTokenSec;
var accToken, accTokenSec;
var pageControlMap = {};

pageControlMap['/getRequestToken'] = function(req, res, urlObj) {
  // 응답할 때 status: 200 OK, 웹브라우저에게 알려줄 정보 - text/plain이고, 문자셋은 UTF-8임을 알림.
  res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
  
  // 트위터로부터 요청토큰(requestToken)을 얻는다.
  twitter.getRequestToken(function(error, requestToken, requestTokenSecret, results){ // 서버에서 requestToken을 받으면 호출되는 함수
    if (error) {
      console.log("Error getting OAuth request token : ");
      console.log('555',error);
      res.end();
    } else {
      //store token and tokenSecret somewhere, you'll need them later; redirect user
      /*
       *  {
       *    "requestToken": "서버로부터 받은 요청토큰값"
       *  }
       */
      reqToken = requestToken;
      reqTokenSec = requestTokenSecret;
      
      res.write('{');
      res.write('   "requestToken": "' + requestToken + '"');
      res.write('}');
      res.end();
    }
    
  });
};

pageControlMap['/getAccessToken'] = function(req, res, urlObj) {
  res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
  
  // 트위터로부터 엑세스 토큰을 발급받는다.
  var oauth_verifier = urlObj.query.oauth_verifier;
  twitter.getAccessToken(
      reqToken,         // 요청 토큰 
      reqTokenSec,      // 요청 토큰 보안키
      oauth_verifier,   // 사용자 검증키(로그인 성공 검증키)
      function(error, accessToken, accessTokenSecret, results) {
    if (error) {
        console.log("Error getting OAuth access token : ");
        console.log('666', error);
        res.end();
    } else {
        //store accessToken and accessTokenSecret somewhere (associated to the user)
        //Step 4: Verify Credentials belongs here
      accToken = accessToken;
      accTokenSec = accessTokenSecret;
      
      res.write('<html><head><title>redirect main</title>');
      res.write('<meta http-equiv="refresh" content="1; url=http://s24.java48.com:8080/twitter/main.html" />');
      res.write('</head><body>');
      res.write('<p>잠시 후 메인 화면으로 이동합니다.</p>');
      res.write('</body></html>');
      
      res.end();
    }
  });
};

pageControlMap['/getUserTimeline'] = function(req, res, urlObj) {
  res.writeHead(200, {'Content-Type': 'text/plain;charset=UTF-8'});
  
  twitter.getTimeline(
      'user_timeline',           // type
      {screen_name: urlObj.query.screen_name},  // params
      accToken,                  // accessToken
      accTokenSec,               // accessTokenSecret
      function(error, data) {   // callback : 작업이 완료했을 때 호출될 함수
        if (error) {
          console.log('cc',error);
          res.write('{"error": "오류!"}');
        } else {
          console.log('gooood!', data);
          res.write('[');
          
          var isFirst = true;
          data.forEach(function(item) {
            if (isFirst) {
              isFirst = false;
            } else {
              res.write(',');
            }
            
            console.log('gooood!');
            
            res.write('{');
            res.write('"text":' + JSON.stringify(item.text)); // javascript 객체를 다시 string 객체로 변경시킴.
            res.write(',"created_at":' + JSON.stringify(item.created_at));
            res.write(',"retweet_count": "' + item.retweet_count + '"');
            res.write(',"favorite_count": "' + (item.retweeted_status?item.retweeted_status.favorite_count:'0') + '"');
            res.write('}');
          });
          
          res.write(']');
        }
        res.end();
      }
  );
};

http.createServer(function (req, res) { // 클라이언트 요청이 들어올 때마다 호출될 함수(requestListener)

  // 누구나 엑세스 허용하도록 만듬(보안에 취약)
  res.setHeader('Access-Control-Allow-Origin', '*');
  
  try {
    // 1. URL 분석: req.url : /getRequestToken
    //  - 쓰기 좋도록 하기 위해
    var urlObj = require('url').parse(req.url, true);
    
    var pageControl = pageControlMap[urlObj.pathname];
    if (pageControl) {
      pageControl(req, res, urlObj);
    } else {
      throw '요청하는 서비스를 찾을 수 없습니다.';
    }
  } catch (err) {
    res.write('{ "error": "' + err + '" }');
    res.end();
  }
  
}).listen(8884, 's24.java48.com'); // 클라이언트의 요청 대기 시작(서버 port 번호:1337)

console.log('Server running at http://s24.java48.com:8884/');

