// 2단계: sum, 관련 함수들을 객체로 묶는다.
//	- sum을 개별적으로 관리할 수 있다.
//	- 자기가 소속된 객체의 변수를 사용할 때는 this를 붙인다.
//	- this는 메서드가 소속된 객체를 가리킴.

// 1000개를 만들 때, 팩토리 메서드를 만들자.
function makeCalculator() {
	
	var calculator = new Object();
	
	calculator.sum = 0;
	calculator.note = '';
	calculator.plus = function(value) {
		this.sum += value;				// 그냥 sum은 글로벌 변수임.
		this.note += ' + ' + value;
	};
	
	calculator.minus = function(value) {
		this.sum -= value;
		this.note += ' - ' + value;
	};
	
	calculator.multiple = function(value) {
		this.sum *= value;
		this.note += ' * ' + value;
	};
	
	calculator.divide = function(value) {
		this.sum /= value;
		this.note += ' / ' + value;
	};
	
	//초기값 : sum에 대해서 value 값으로 초기화
	calculator.init = function(value) {
		if (arguments.length == 0) {  // *** 중요 ***
			this.sum = 0;
			this.note = '';
		} else {
			this.sum = value;
			this.note = String(value);
		}
	};
	
	calculator.printResult = function() {
		console.log(this.note + ' = ', this.sum );
	};
	
	return calculator;
}



