package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseMgt {
	
	public static void insert(Statement stmt) throws Exception {
		stmt.executeUpdate(
				"insert SE_COURS(TITLE, DEST, HOURS) "
				+ "values('임베디드 리눅스 고급과정', '임베디드 리눅스 고급과정',1200)");
	}
	
	public static void list(Statement stmt) throws Exception{
		ResultSet rs = stmt.executeQuery("select CNO, TITLE, DEST, HOURS from SE_COURS");
		
		while (rs.next()) {
			System.out.print(rs.getInt("CNO") + ",");
			System.out.print(rs.getString("TITLE") + ",");
			System.out.print(rs.getString("DEST") + ",");
			System.out.println(rs.getInt("HOURS"));
		}
		
		rs.close();
		
	}
	
	public static void update(Statement stmt) throws Exception {
		stmt.executeUpdate(
				"update SE_COURS set"
				+ " TITLE='[국비지원]임베디드 리눅스 고급과정'"
				+ " where CNO=3");
	}
	
	public static void delete(Statement stmt) throws Exception {
		stmt.executeUpdate(
				"delete from SE_COURS where CNO=5");
	}
	
	
	// SE_COURS	CNO:int, TITLE, DEST, HOURS:int
	public static void main(String[] args) throws Exception {
		
		// 1. 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb",
				"study",
				"study");
		
		// 연결 확인
		System.out.println("[강진] 연결완료!");
		
		// 3. Connection로부터 Statement 구현체 얻기
		Statement stmt = con.createStatement();
		
		// 4. insert, update, delete, list
		
		//insert(stmt);
		//update(stmt);
		//delete(stmt);
		list(stmt);
		
		
		
		// 5. 연결 종료
		stmt.close();
		con.close();

	}


}
