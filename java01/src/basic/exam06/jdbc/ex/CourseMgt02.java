package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CourseMgt02 {
	
	public static void insert() {
		
	}
	
	public static void list() {
		
	}
	
	public static void update() {
		
	}
	
	public static void delete() {
		
	}

	public static void main(String[] args) throws Exception {
		// 1. 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 연결 객체 가져오기
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb",	// jdbc URL
				"study",				// username
				"study");				// password
		
		// 3. 연결 확인
		System.out.println("연결 확인!");
		
		// 4. 연결로부터 Statement 구현체 얻기
		Statement stmt = con.createStatement();
		
		// 5. insert, update, delete, list
		
		insert();
		//update();
		//delete();
		list();
		
		// 6. 연결 종료
		stmt.close();
		con.close();
	}

}
