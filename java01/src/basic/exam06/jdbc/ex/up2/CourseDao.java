package basic.exam06.jdbc.ex.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
	
	// Scanner scanner = new Scanner(System.in);
	
	public void insert(CourseVo course) throws Throwable {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.200.91:3306/studydb",
					"study",
					"study");

			stmt = con.prepareStatement(
					"insert SE_COURS(TITLE, DEST, HOURS)"
							+ " values(?, ?, ?)");

			stmt.setString(1, course.title);
			stmt.setString(2, course.description);
			stmt.setInt(3, course.hours);

			stmt.executeUpdate();
		
		} catch (Throwable e) {
			throw e;
		} finally {
			try {	stmt.close(); } catch (Throwable e2) {}
			try {	con.close(); } catch (Throwable e2) {}
		}
	}
	
	public void update(CourseVo course) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.200.91:3306/studydb",
					"study",
					"study");

			stmt = con.prepareStatement(
					"update SE_COURS set"
							+ " TITLE=?"
							+ " where CNO=?");

			System.out.print("[TITLE]:");
			stmt.setString(1, course.title);

			System.out.print("[CNO]:");
			stmt.setInt(2, course.no);

			stmt.executeUpdate();

			stmt.close();

		} catch (Throwable e) {
			throw e;
		} finally {
			try {	stmt.close(); } catch (Throwable e2) {}
			try {	con.close(); } catch (Throwable e2) {}
		}
	}
	
	public List<CourseVo> list(int pageNo, int pageSize) throws Throwable {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.200.91:3306/studydb",
					"study",
					"study");
			
			stmt = con.prepareStatement(
					"select CNO, TITLE, DEST, HOURS"
							+ " from SE_COURS"
							+ " order by CNO desc"
							+ " limit ?, ?");

				stmt.setInt(1, (pageNo - 1) * pageSize);
				stmt.setInt(2, pageSize);

				rs = stmt.executeQuery();

				ArrayList<CourseVo> list = new ArrayList<CourseVo>();
				CourseVo course = null;
				
				while (rs.next()) {
					course = new CourseVo();
					course.no = rs.getInt("CNO");
					course.title = rs.getString("TITLE");
					
					list.add(course);
				}
				
				return list;

		} catch (Throwable e) {
			throw e;
		} finally {
			try {	rs.close(); } catch (Throwable e2) {}
			try {	stmt.close(); } catch (Throwable e2) {}
			try {	con.close(); } catch (Throwable e2) {}
		}
	}
	
	public CourseVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.200.91:3306/studydb",
					"study",
					"study");
			
			stmt = con.prepareStatement(
					"select CNO, TITLE, DEST, HOURS"
							+ " from SE_COURS"
							+ " where CNO=?");

				stmt.setInt(1, no);

				rs = stmt.executeQuery();

				if (rs.next()) {
					CourseVo course = new CourseVo();
					course.no = rs.getInt("CNO");
					course.title = rs.getString("TITLE");
					course.description = rs.getString("DEST");
					course.hours = rs.getInt("HOURS");
					
					return course;
				} else {
					throw new Exception("해당 과목을 찾을 수 없습니다.");
				}
				
		} catch (Throwable e) {
			throw e;
		} finally {
			try {	rs.close(); } catch (Throwable e2) {}
			try {	stmt.close(); } catch (Throwable e2) {}
			try {	con.close(); } catch (Throwable e2) {}
		}
	}
	
	public void delete(int no) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://192.168.200.91:3306/studydb",
					"study",
					"study");
			
		PreparedStatement stmt = con.prepareStatement(
				"delete from SE_COURS where CNO=?");
		
		System.out.print("[Insert CNO to delete] : ");
		stmt.setInt(1, Integer.parseInt(scanner.nextLine()));
		
		stmt.executeUpdate();
		
	} catch (Throwable e) {
		throw e;
	} finally {
		try {	rs.close(); } catch (Throwable e2) {}
		try {	stmt.close(); } catch (Throwable e2) {}
		try {	con.close(); } catch (Throwable e2) {}
	}
	}
	

}
