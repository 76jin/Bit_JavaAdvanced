package basic.step03;

public class Control01 {

	public static void main(String[] args) {
/*		// 테스트 1 : 간단한 조건문
		int a = 3;
		if( a > 4)
			System.out.println("a > 4 입니다.");
			System.out.println("종료합니다!");
*/
/*		// 테스트 2 : { } 을 사용하여 수행할 명령어를 묶어줌.
		int a = 5;
		if(a > 0) {
			System.out.println("a > 0 입니다.");
			a = -5;
		}
		
		if(a < 0) {
			System.out.println("a < 0 입니다.");
			a = 0;
		}
*/
/*		// 테스트 3 : if... else 
		int a = 5;
		if(a > 0) 
			System.out.println("a > 0 입니다.");
		else 
			System.out.println("a <= 0 입니다.");

*/
/*		// 테스트 4 : if... else if... else
		int a = 0;
		if(a > 0)
			System.out.println("a > 0 입니다.");
		else
			if (a < 0)
				System.out.println("a < 0 입니다.");
			else
				if(a == 0)
					System.out.println("a == 0 입니다.");
				else
					System.out.println("허~~~ 0도, 음수도, 양수도 아닌수가 있나요?");
		// 내가 봐도 복잡하다. 허~~~ 이것을 좀더 알아보기 쉽도록 모양을 좀 내 봅시다.
*/
/*
		// 다음과 같이 정리하는게 나을것 같네요...
		int a = 0;
		if(a > 0)
			System.out.println("a > 0 입니다.");
		else if (a < 0)
			System.out.println("a < 0 입니다.");
		else if(a == 0)
			System.out.println("a == 0 입니다.");
		else
			System.out.println("허~~~ 0도, 음수도, 양수도 아닌수가 있나요?");

		//  어떻습니까? 보기도 좋고, 이해하기도 좋지 않습니까?
*/
		// 테스트 5 : 과연 else는 어디 소속일까요?
		int a = -5;
		if (a >= 0)
			if(a == 0)
				System.out.println("a == 0 입니다.");
		else
			System.out.println("a < 0 입니다.");

		// 결과는 아무런 것도 출력되지 않을 것이다!
		// else 는 가장 가까운 if 문에 속하게 된다.
		// 위의 예제는 모양은 그럴싸 하지만, '결코 날 속일 수 없어!'
		// 결국 다음과 같이 정리된다.
		// if (a > = 0)
		//		if(a == 0)
		//			System.out.println("a == 0 입니다.");
		//		else
		//			System.out.println("a < 0 입니다.");
		// 요렇게...
	}

}
