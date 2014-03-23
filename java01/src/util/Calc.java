// 이 class가 어떤 block에 속해 있는지를 명시해 줘야 함.
// 이를 위해 package라는 지시어를 사용함.
// 특정 폴더에 소속된 클래스 블럭은 반드시
// 소스 파일에 소속 클래스 블럭을 밝혀야 한다.
package util;

public class Calc {
	public static int plus(int a, int b) {
		return (a + b);
	}
	
	public static int minus(int a, int b) {
		return (a - b);
	}
}