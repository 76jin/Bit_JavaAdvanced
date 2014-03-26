package basic.exam04.step05;

/* 콤마(,)로 구분된 문자열 데이터(comma seperated value: CSV)로부터 인스턴스 생성하기
 * 	- 클래스 메서드(static 메서드)의 활용 사례 공부
 * 	- 데이터 항목이 추가되거나, 문자열의 표현 순서가 바뀌더라도 소스코드를 유지보수하기 쉽다.
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
	
	/* 클래스 메서드
	 * 	- 특정 인스턴스를 위해 작업하지 않는다.
	 * 	- 모든 인스턴스를 대상으로 공통 작업을 수행한다.
	 * 	- this 변수를 쓰지 않는다면 굳이 인스턴스 메서드로 쓸 필요가 없다.
	 */
	public static StudentScore fromCSV(String value) {
		String[] data = value.split(",");
		
		// 콤마로 구분된 문자열 데이터를 객체로 만들어준다는 걸 강조하기 위해서 변수명을 obj로 함.
		StudentScore obj = new StudentScore(data[0]);
		obj.kor  = Integer.parseInt(data[1]);
		obj.eng  = Integer.parseInt(data[2]);
		obj.math = Integer.parseInt(data[3]);
		
		return obj;
	}

	public String toString() {
	  return name + "," + kor + "," + eng + "," + math;
  }
	
	

}
