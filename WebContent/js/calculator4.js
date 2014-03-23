// 4단계: 공용함수 공유
//	- prototype : 공유자원 보관소
//	- 사용: 생성자 함수.prototype

// 1000개를 만들 때, 팩토리 메서드를 만들자.
// 그 다음엔 생성자 함수를 만들자!!!
function Calculator() {
	this.sum = 0;
	this.note = '';
}

Calculator.prototype.plus = function(value) {
	this.sum += value;				// 그냥 sum은 글로벌 변수임.
	this.note += ' + ' + value;
};

Calculator.prototype.minus = function(value) {
	this.sum -= value;
	this.note += ' - ' + value;
};

Calculator.prototype.multiple = function(value) {
	this.sum *= value;
	this.note += ' * ' + value;
};

Calculator.prototype.divide = function(value) {
	this.sum /= value;
	this.note += ' / ' + value;
};

//초기값 : sum에 대해서 value 값으로 초기화
Calculator.prototype.init = function(value) {
	if (arguments.length == 0) {  // *** 중요 ***
		this.sum = 0;
		this.note = '';
	} else {
		this.sum = value;
		this.note = String(value);
	}
};

Calculator.prototype.printResult = function() {
	console.log(this.note + ' = ', this.sum );
};



