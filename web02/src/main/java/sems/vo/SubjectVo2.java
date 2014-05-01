package sems.vo;

/* setter/getter 적용 <= 캡슐화
 */
public class SubjectVo2 {
	private int 				no;				// DB 컬럼과 연결. 컬럼명 사용하지 말것. 일반 용어 사용.
	private String 		title;   // 다른 프로젝트에서 재사용할 때 제약이 없다.
	private String 		description;
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
