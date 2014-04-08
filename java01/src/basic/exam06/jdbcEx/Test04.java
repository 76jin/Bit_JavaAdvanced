package basic.exam06.jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb",
				"study",
				"study");
		
		// 3. 연결 확인
		System.out.println("연결되었다!");
		
		// 4. 연결 종료
		con.close();
	}

}
