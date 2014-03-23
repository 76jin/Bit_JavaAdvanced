/*
 * 전역함수를 객체의 속성으로 지정하여 함수이름 충돌을 피한다.
 * 객체는 언제든지 속성을 추가할 수 있다.
 */

function bit(selector) {
  var elements = document.querySelectorAll(selector);
  
  elements.click = function(lisener) {
    for (var i=0; i < this.length; i++) {
      this[i].onclick = lisener;
    }
  };
  
  elements.css = function(name, value) {
    for (var i=0; i < this.length; i++) {
      this[i].style[name] = value;
    }
  };
  
  elements.append = function(child) {
    for (var i=0; i < this.length; i++) {
      this[i].appendChild(child);
    }
  };
  
  elements.remove = function() {
    for (var i=0; i < this.length; i++) {
      this[i].parentNode.removeChild(this[i]);
    }
  };
  
  elements.dispatchEvent = function(eventType) {
    var event = null;
    if (eventType == 'click') {
      event = new MouseEvent('click', {
        view: window,
        bubbles: true,
        cancelable: true
      });
    } else {
      return;
    }
    
    for (var i=0; i < this.length; i++) {
      this[i].dispatchEvent(event);
    }
  };
  
  elements.val = function(value) {
    if (arguments.length == 0) {
      return this[0].value;
    } else {
      for (var i=0; i < this.length; i++) {
        this[i].value = value;
      }
    }
  };
  
  return elements;
}


/*
 * AJAX 기능 수행
 * url : 서비스를 가리키는 URL, string
 * options : AJAX 요청시 필요한 값을 담은 객체
 *  data    - 원격 함수에 전달할 데이터
 *  success - 원격 함수의 호출이 성공적으로 끝났을 때 호출될 메서드
 *  error   - 원격 함수의 호출이 실패했을 때 호출될 메서드
 *  method  - 원격 함수 호출 방법(요청 방식: GET, POST)
 */
bit.ajax = function(url, options) {
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var result = JSON.parse(xhr.responseText).jsonResult;
      if (result.resultStatus == 0) { // 원격 함수 호출 성공!
        if (options.success)
          options.success(result.data);
      } else {  // 원격 함수 호출 실패!
        if (options.error)
          options.error(result.error);

      }
    }
  };

  xhr.open(options.method, url, true);
  if (options.method == 'GET') {
    xhr.send(null);
  } else {
    var queryString = '';
    for (var key in options.data) {
      if (queryString.length > 0)
        queryString += '&';
      
      queryString += key + '=' + options.data[key];
    }

    // POST 방식은 아래 header를 붙여줘야 서버에서 이게 POST인지 알 수 있다.
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.send(queryString); 
  }
};

//Javascript 에서는 변수, 함수 이름으로 $ 가능함. 자주 사용.
//타 변수와 충돌날까 제일 아래 적음.
var $ = bit;
