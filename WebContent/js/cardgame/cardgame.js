/**
 * 
 */
"user strict";

/*
  1. 게임에 사용할 카드 이미지 배열 선언
  2. 카드정보( 위치, 이미지, 등 )를 나타낼 Card객체 선언
  3. 필요 변수 선언
  4. 게임초기화( 카드리스트를 만들고, 랜덤하게 순서섞기 )
  5. 카드 클릭 시 카드 뒤집기
  6. 클릭 한 카드가 2개가 되면 뒤집힌 카드비교
  7. 같은 카드면 제거하면서 성공한 count값 1증가, 아니면 다시 원위치
  8. count값이 카드쌍과 동일하면 완료를 알림
 */

// 1. 게임에 사용할 카드 이미지 배열 선언

// 2. 카드정보( 위치, 이미지, 등 )를 나타낼 Card객체 선언
/* cardItem선언 */
/*function Card( sx, sy, img, index ){
  this.sx     =sx;
  this.sy     =sy;
  this.index  =index;
  this.img    =img;
};*/

/*function Card(id, hiddenImage) {
	this.id = id;
	this.hiddenImage = hiddenImage;
	this.coverImage = '00.jpg';
	this.same = false;
}

Card.prototype.addListener = function() {
	alert('Card.prototype.addListener');
};*/


// 백그라운드 이미지
// <div style="width:250; height:250; background-image: url(bg.gif)"></div>

/*
// 3초 후에 함수를 실행합니다.
setTimeout(function () {
    alert('3초가 지났습니다. ㅇㅂㅇ');
}, 3000);*/


// 1. div.btn 찾는다.
/* var divList = document.querySelectorAll('.btn'); */
/*var divList = document.getElementsByTagName('div');
for (var i = 0; i < divList.length; i++) {
	divList[i].addEventListener('click', function() {
		document.body.removeChild(this);
	});
}*/

// onclick : 변수명, property, 속성임
// click : 이벤트명
// addEventListener : 여러개의 함수를 등록할 수 있음.

