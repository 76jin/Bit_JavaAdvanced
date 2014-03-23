package basic.step01;

/* 
 * float : 유효자리수 7자리까지 정확하게 저장
 * double : 유효자리수 15자리까지 정확하게 저장
 * 유효자리수 범위를 넘으면 반올림하여 출력된다고 함.
 */
public class Variable06 {

	public static void main(String[] args) {
		// 테스트 float
		// 유효자리수(7자리) 범위내의 값을 할당할 경우
		float 변수1 = 42224478F;
		float 변수2 = 987654.3f;
		float 변수3 = 9.876543f;

		// 유효자리수 범위를 초과하여 값을 할당할 경우
		float 변수4 = 987.65434436f;

		System.out.println(변수1);
		System.out.println(변수2);
		System.out.println(변수3);

		System.out.println(변수4);

		// 테스트 double
		// 유효 자리수(15자리) 범위내의 값을 할당할 경우
		double 변수5 = 987654321987654d;
		double 변수6 = 98765432198765.4;
		double 변수7 = 9.87654321987654;

		// 유효자리수 범위를 초과하여 값을 할당할 경우
		double 변수8 = 987.654321987654678;

		System.out.println(변수5);
		System.out.println(변수6);
		System.out.println(변수7);

		System.out.println(변수8);

	}

}
