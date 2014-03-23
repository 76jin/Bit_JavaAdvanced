package basic.step04;

/* 참조 변수
 * 	- 자바에서는 포인터의 역할이 축소되어 있다.
 * reference 형
 * 	class형, interface형, array형
 * reference 값 : 객체에 대한 포인터(주소)임.
 * ==> 참조변수는 객체의 주소를 담는 변수이다.
 */

public class Array01 {

	public static void main(String[] args) {
		// int[] a = null;	// 객체가 없음을 나타내는 reference값
		int[] 과목 = new int[19];
		
		for (int i=0; i < 10; i++)
			System.out.println("과목[" + i + "] = " + 과목[i]);
		
		과목 = new int[10];
		
		for (int i=0; i < 10; i++)
			과목[i] = 100 * i;
		
		for (int i=0; i < 10; i++)
			System.out.println("과목[" + i + "] = " + 과목[i]);
	}

}
