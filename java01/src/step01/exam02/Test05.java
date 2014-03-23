package step01.exam02;

/* 생성자
 * 	- 인스턴스 생성 직후 자동으로 호출되는 메서드
 * 	- 인스턴스 변수를 초기화
 * 
 */

public class Test05 {

	public static void main(String[] args) {
		// 10 + 30 - 4 * 7 = 252 (연산자 우선순위 고려하지 않음)
		// 5 * 3 - 6 / 3 = 3
		
		Calculator05 calc1 = new Calculator05(10);
		Calculator05 calc2 = new Calculator05(5);
		
//	calc1.init(10);
//	calc2.init(5);
		
		calc1.plus(30);
		calc2.multiple(3);
		
		calc1.minus(4);
		calc2.minus(6);
		
		calc1.multiple(7);
		calc2.divide(3);
		
		System.out.println("result: " + calc1.result);
		System.out.println("result: " + calc2.result);
	}

}
