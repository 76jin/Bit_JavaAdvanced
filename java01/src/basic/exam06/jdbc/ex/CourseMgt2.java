package basic.exam06.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// Statement를 PreparedStatement로 변경

public class CourseMgt2 {
	
	public static void insert(Connection con) throws Exception {
		PreparedStatement stmt = con.prepareStatement(
				"insert SE_COURS(TITLE, DEST, HOURS)"
				+ " values(?, ?, ?)");
		
		Scanner scanner = new Scanner(System.in);
		
		stmt.setString(1, scanner.nextLine());
		stmt.setString(2, scanner.nextLine());
		stmt.setInt(3, Integer.parseInt(scanner.nextLine()));
		
		stmt.executeUpdate();
		
		scanner.close();
		stmt.close();
	}
	
	public static void list(Connection con) throws Exception{
		PreparedStatement stmt = con.prepareStatement(
				"select CNO, TITLE, DEST, HOURS"
				+ " from SE_COURS"
				+ " order by CNO desc"
				+ " limit ?, ?");
		
		Scanner scanner = new Scanner(System.in);
		ResultSet rs = null;
		int pageNo = 1, pageSize = 10;
		
		do {
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			
			rs = stmt.executeQuery();
			
			System.out.println("[" + pageNo + "]---------------------------");
			
			while (rs.next()) {
				System.out.print(rs.getInt("CNO") + ",");
				System.out.print(rs.getString("TITLE") + ",");
				System.out.print(rs.getString("DEST") + ",");
				System.out.println(rs.getInt("HOURS"));
			}
			
			rs.close();
			
			pageNo = Integer.parseInt(scanner.nextLine());
			
		} while (pageNo > 0);
		
		stmt.close();
		
	}
	
	public static void update(Connection con) throws Exception {
		PreparedStatement stmt = con.prepareStatement(
				"update SE_COURS set"
				+ " TITLE=?"
				+ " where CNO=?");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("[TITLE]:");
		stmt.setString(1, scanner.nextLine());
		
		System.out.print("[CNO]:");
		stmt.setInt(2, Integer.parseInt(scanner.nextLine()));
				
		stmt.executeUpdate();
		
		scanner.close();
		stmt.close();
	}
	
	public static void delete(Connection con) throws Exception {
		PreparedStatement stmt = con.prepareStatement(
				"delete from SE_COURS where CNO=?");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("[Insert CNO to delete] : ");
		stmt.setInt(1, Integer.parseInt(scanner.nextLine()));
		
		stmt.executeUpdate();
		
		scanner.close();
		stmt.close();
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
		//PreparedStatement stmt = null;
		
		// 4. insert, update, delete, list
		
		//insert(con);
		//update(con);
		//delete(con);
		list(con);
		
		System.out.println("[강진] CRUD 완료!");
		
		// 5. 연결 종료
		//stmt.close();
		con.close();

	}


}
