package basic.exam04.step02;

/* 데이터를 표현하는 클래스 : Value Object => Data Transfer Object (DTO)
 * 	- 복합 데이터의 새로운 유형을 정의한다.
 * 		=> 새로운 형식의 데이터 타입을 정의.
 * 	- 데이터 타입 예)
 * 			=> byte, short, int, long, float, double, boolean, char
 */
public class StudentScore {
	// 인스턴스 변수: 값을 개별로 다루어야 한다면 인스턴스 변수로 선언한다.
	String name;
	int kor;
	int eng;
	int math;
	
	// 생성자: 
	//	- name
	//		=> 
	public StudentScore(String name) {
		this.name = name;
		
	}

}
