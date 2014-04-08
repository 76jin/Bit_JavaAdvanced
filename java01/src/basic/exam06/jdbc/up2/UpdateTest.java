package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/* update 요청
 * 	- executeUpdate() 사용
 * 
 * update SQL
 * 	- update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건
 * 
 */

public class UpdateTest {

	public static void main(String[] args) throws Exception {
		// 1. 드라이버 로딩 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb",		// jdbc URL 
				"study", 				// username
				"study");				// password
		
		// 3. Connection으로부터 Statement 구현체를 얻는다.
		PreparedStatement stmt = con.prepareStatement(
				"update SE_SUBJS set"
				+ " TITLE=?"
				+ " where SNO=?");

		Scanner scanner = new Scanner(System.in);
		stmt.setString(1, scanner.nextLine());
		stmt.setInt(2, 1);
		stmt.executeUpdate();
		
		scanner.close();
		
		System.out.println("변경 성공!");
		
		stmt.close();
		con.close();		// 서버에 연결 종료를 호출한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때까지 연결을 유지한다.
	}

}

// interface 규칙을 따르는 인스턴스를 리턴함.
// 참조 변수를 받을 때는 인터페이스로 받음음로써 
// 소스코드의 종속성을 막을 수 있다.
// 
