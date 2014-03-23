package basic.step02;

public class Operator05 {

	public static void main(String[] args) {
/*
 * 	// 테스트 1 : 기본 테스트
		boolean b = true;
		boolean b2 = false;
		
		System.out.println("b && b2 = " + (b && b2));	// false
		System.out.println("b || b2 = " + (b || b2));	// true
		System.out.println("b & b2 = " + (b & b2));		// false
		System.out.println("b | b2 = " + (b | b2));		// true
		System.out.println("!b = " + !b);							// false
		 //
*/
/*
		// 테스트 2 : &&, || 와 & , |의 차이점을 알아보자!
		boolean r = false;
		boolean b2 = false;
		boolean s = b2 & (r = true);
		
		System.out.println("s = " + s);	// false 
		System.out.println("r = " + r);	// true
*/
		/* 해설
		 * - '&' 연산자는 피연산자 b2 와 (r = true) 를 모두 수행한다.
		 */
/*
		// 테스트 3
		boolean r = false;
		boolean b2 = false;
		boolean s = b2 && (r = true);
		
		System.out.println("s = " + s);	// false
		System.out.println("r = " + r);	// false
*/		 //
		/* 해설
		 * - '&&' 연산자는 피연산자 b2가 false이면 이미 결과가 false이므로
		 *   다른 피연산자인 (r = true)를 수행하지 않는다.
		 */

/*
		// 테스트 4
		boolean r = false;
		boolean b = true;
		boolean s = b | (r = true);
		
		System.out.println("s = " + s);	// true
		System.out.println("r = " + r);	// true
*/		 //
		/* 해설
		 * - '|' 연산자는 피연산자 b 와 (r = true) 모두 수행한다.
		 */
/*
		// 테스트 5
		boolean r = false;
		boolean b = true;
		boolean s = b || (r = true);
		
		System.out.println("s = " + s);	// true
		System.out.println("r = " + r);	// false
*/		 //
		/* 해설
		 * - '||' 연산자는 피연산자 b가 true이면 이미 결과가 true이므로
		 *   다른 피연산자 (r = true)를 수행하지 않는다.
		 */
/*
		// 테스트 6 : 논리연산자의 피연산자는 boolean type만 될수 있다.
		int i = 10, i2 = 20;
		boolean r = i && i2;	// true && true
		System.out.println("r = " + r);	// true
		 //
*/
		// 테스트 7 : &와 | 는 비트 연산자로서도 사용되는 이중성을 가진다.
		int i = 10, i2 = 20;
		boolean r = i & i2;	// 0
		System.out.println("r = " + r);	// 0

		// '&' 는 비트 연산자로서 사용됨으로써 결과는 정수가 되고, 
		//  따라서, int 값을 boolean 변수에 할당 할수 없다. type이 맞지않는다.
		 //
	}

}
