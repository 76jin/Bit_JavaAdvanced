package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {

	public static void main(String[] args) throws Exception {
		// 1. 드라이버 로딩 
		//	: java.jdbc.Driver 구현체를 로딩 => JDBC 드라이버 관리자에 등록
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		//	- Driver로부터 직접 Connection 객체를 얻지 않는다.
		//	=> DriverManager에게 요청 => Driver의 connect() 호출
		//	=> Driver는 Connection 객체를 리턴 => DriverManager는 받은 걸 리턴.
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb",		// jdbc URL 
				"study", 				// username
				"study");				// password
		
		System.out.println("[강진]오호라.. 연결되었다!");
		
		con.close();		// 서버에 연결 종료를 호출한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때까지 연결을 유지한다.
	}

}

// interface 규칙을 따르는 인스턴스를 리턴함.
// 참조 변수를 받을 때는 인터페이스로 받음음로써 
// 소스코드의 종속성을 막을 수 있다.
// 
