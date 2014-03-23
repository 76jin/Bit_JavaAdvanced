package step01.exam03.test02;

/* 기본 타입 랩퍼(Wrapper) 클래스
 * 	- 기본 타입의 값을 좀 더 정교하게 다룰 수 있도록 클래스를 제공한다.
 * 	- byte 		=> java.lang.Byte
 * 	- short		=> java.lang.Short
 * 	- char 		=> java.lang.Charater
 * 	- int			=> java.lang.Integer
 * 	- long		=> java.lang.Long
 * 	- float		=> java.lang.Float
 * 	- double	=> java.lang.Double
 * 	- boolean	=>java.lang.Boolean
 * 	- 랩퍼 클래스는 equals()를 재정의 하였다. => 내용을 비교할 수 있다.
 */
public class Episode02 {
	
	public static void main(String[] args) {
		// 기본 데이터형과 랩퍼 클래스 사이의 교류: cross over => Auto-boxing, unboxing
		// 기본 데이터형 변수와 랩퍼 객체 사이의 값을 교환하기가 불편함!
		Integer i1 = new Integer(10);
		int i2 = i1.intValue();

		int i3 = 100;
		Integer i4 = new Integer(i3);
		
		// 기본 데이터형 <-> 랩퍼 객체 변환 자동화
		// 기본 데이터형의 값을 자동으로 랩퍼 객체로 만드는 것
		//	-> 랩퍼 객체에 보관
		//	-> 랩퍼 객체에 포장
		//	"Auto-boxing"
		Integer i5 = 20;	// 랩퍼 객체로 자동 포장 => new Integer(20) 과 같음.
		
		// 랩퍼 객체의 값을 기본 데이터형으로 뽑아내는 것
		//	-> 랩퍼 객체에 들어 있는 값을 꺼냄
		//	-> 랩퍼 객체의 포장을 품
		//	"Auto-unboxing"
		int i6 = i5;			// 자동으로 포장 해제 => i5.intValue() 와 같다.
	}
		
	public static void main01(String[] args) {
		// 랩퍼 클래스의 사용: hashCode()와 equals() 재정의 여부테스트
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		
		if (i1 == i2)
			System.out.println("i1 == i2");
		
		if (i1.equals(i2))
			System.out.println("i1.equals(i2)"); // 내용 비교하도록 재정의 됨
		
		
	}

}
