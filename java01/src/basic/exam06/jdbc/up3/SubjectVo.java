package basic.exam06.jdbc.up3;

/* DTO (Data Transfer Object) = VO (Value Object)
 * 	- 데이터를 담는 그릇 역할
 * 	- layer 간의 데이터 교환 시 사용됨.
 * 	- 테이블 <---> VO
 * 	- 테이블A + 테이블B + ... <---> VO 가능
 */

public class SubjectVo {
	int 		no;						// DB 컬럼과 연결.. 그러나 컬럼명 사용 말것. 일반용어 사용.
	String 	title;				// 다른 프로젝트에서 재사용할 때 제약이 없다.
	String 	description;
	
}
