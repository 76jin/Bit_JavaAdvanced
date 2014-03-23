//계산기 관련 코드

var sum = 0;
var note = '';
function plus(value) {
	sum += value;
	note += ' + ' + value;
}

function minus(value) {
	sum -= value;
	note += ' - ' + value;
}

function multiple(value) {
	sum *= value;
	note += ' * ' + value;
}

function divide(value) {
	sum /= value;
	note += ' / ' + value;
}

//초기값 : sum에 대해서 value 값으로 초기화
function init(value) {
	if (arguments.length == 0) {  // *** 중요 ***
		sum = 0;
		note = '';
	} else {
		sum = value;
		note = String(value);
	}
}

function printResult() {
	console.log(note + ' = ', sum );
}
