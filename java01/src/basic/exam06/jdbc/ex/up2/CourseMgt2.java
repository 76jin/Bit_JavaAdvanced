package basic.exam06.jdbc.ex.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import basic.exam06.jdbc.up2.SubjectDao;
import basic.exam06.jdbc.up2.SubjectVo;

// CourseDao 사용
public class CourseMgt2 {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void insert() throws Throwable {
		
		CourseVo course = new CourseVo();
		course.title = "[국가전략산업] 자바 고급";
		course.description = "국가에서 전략적으로 지원하는 자바 고급 개발자 과정";
		course.hours = 1100;
		
		CourseDao dao = new CourseDao();
		dao.insert(course);
		
		System.out.println("등록 성공!");
	}
	
	public static void list() throws Throwable{
		
		CourseDao dao = new CourseDao();
		Scanner scanner = new Scanner(System.in);
		int pageNo = 1, pageSize = 10;
		
		do {
			List<CourseVo> list = dao.list(pageNo, pageSize);
			
			System.out.println("[" + pageNo + "]----------------------------");
			
			for (CourseVo course : list) {
				System.out.print(course.no + ",");
				System.out.println(course.title);
			}
			
			pageNo = Integer.parseInt(scanner.nextLine());
			
		} while (pageNo > 0);
		
		scanner.close();
	}
	
public static void detail() throws Throwable{
	
	CourseDao dao = new CourseDao();
	Scanner scanner = new Scanner(System.in);
	
	CourseVo course = dao.detail( Integer.parseInt(scanner.nextLine()));
	
	System.out.print(course.no);
	System.out.print(course.title);
	System.out.print(course.description);
	System.out.print(course.hours);
	
	scanner.close();
		
	}
	
	public static void update() throws Throwable {
		
		CourseDao dao = new CourseDao();
		CourseVo course = new CourseVo();
		course.no = 108;
		course.title = "와우 변경됐군요.";
		course.description = "이제 변경도 계속하자";
		
		dao.update(course);
		
		System.out.println("변경확인!");
	}
	
	public static void delete() throws Throwable {
		PreparedStatement stmt = con.prepareStatement(
				"delete from SE_COURS where CNO=?");
		
		System.out.print("[Insert CNO to delete] : ");
		stmt.setInt(1, Integer.parseInt(scanner.nextLine()));
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	
	// SE_COURS	CNO:int, TITLE, DEST, HOURS:int
	public static void main(String[] args) throws Throwable {
		
		//insert();
		//update();
		//delete();
		list();
		
		System.out.println("[강진] CRUD 완료!");
		
	}

}
