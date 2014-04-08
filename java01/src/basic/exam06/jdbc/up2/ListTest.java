package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/* 페이징 처리
 */

public class ListTest {

	public static void main(String[] args) throws Exception {
		// 1. 드라이버 로딩 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb", 
				"study",
				"study");
		
		// 3. Connection으로부터 Statement 구현체를 얻는다.
		/* 
		 * select sno, title, dest 
				from SE_SUBJS 
				order by sno desc
				limit 페이지 시작 인덱스, 페이지당 출력 개수
		 */
		PreparedStatement stmt = con.prepareStatement(
				"select SNO, TITLE, DEST"
						+ " from SE_SUBJS"
						+ " order by SNO desc"
						+ " limit ?, ?");
		
		Scanner scanner = new Scanner(System.in);
		ResultSet rs = null;
		int pageNo = 1, pageSize = 10;
		
		do {
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			
			rs = stmt.executeQuery();
		
			System.out.println("[" + pageNo + "]-----------------------------");
			
			// 서버에 결과 요청하기
			while (rs.next()) {
				// 컬럼의 타입과 일치하는 메서드를 사용하여 값을 꺼낸다.
				System.out.print(rs.getInt("SNO") + ",");
				System.out.print(rs.getString("TITLE") + ",");
				System.out.println(rs.getString("DEST"));
			}
			
			rs.close();
			
			pageNo = Integer.parseInt(scanner.nextLine());
			
		} while(pageNo > 0);
		
		stmt.close();
		con.close();		// 서버에 연결 종료를 호출한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때까지 연결을 유지한다.
	}

}
