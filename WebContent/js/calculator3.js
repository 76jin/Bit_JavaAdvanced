// 3단계: 생성자 함수

// 1000개를 만들 때, 팩토리 메서드를 만들자.
// 그 다음엔 생성자 함수를 만들자!!!
function Calculator() {
	
	// 이미 빈 객체가 존재할테니까 필요없음.
	/*var calculator = new Object();*/
	
	this.sum = 0;
	this.note = '';
	this.plus = function(value) {
		this.sum += value;				// 그냥 sum은 글로벌 변수임.
		this.note += ' + ' + value;
	};
	
	this.minus = function(value) {
		this.sum -= value;
		this.note += ' - ' + value;
	};
	
	this.multiple = function(value) {
		this.sum *= value;
		this.note += ' * ' + value;
	};
	
	this.divide = function(value) {
		this.sum /= value;
		this.note += ' / ' + value;
	};
	
	//초기값 : sum에 대해서 value 값으로 초기화
	this.init = function(value) {
		if (arguments.length == 0) {  // *** 중요 ***
			this.sum = 0;
			this.note = '';
		} else {
			this.sum = value;
			this.note = String(value);
		}
	};
	
	this.printResult = function() {
		console.log(this.note + ' = ', this.sum );
	};
}



