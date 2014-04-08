package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Statement 사용
//	- DBMS에 질의를 수행하는 역할
//	- executeQuery() : select 문 수행
//	- executeUpdate() : SQL에서 DDL, DML (Data Manipulation Language)을 다룰 때 사용
//											insert, drop, alter, insert, update, delete
//	- execute() : DDL(Data Definition Language), DML, DQL(select)

// SQL - insert
// insert 테이블명(컬럼명, 컬럼명, ...) values(값, 값,...)
//	- 문자열 값은 '' 기호 안에 작성한다. "" 사용 불가!!
//	- 숫자는 그냥 작성한다.

public class Test02 {

	public static void main(String[] args) throws Exception {
		// 1. 드라이버 로딩 
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2. DB 커넥션 객체 가져오기
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.91:3306/studydb",		// jdbc URL 
				"study", 				// username
				"study");				// password
		
		// 3. Connection으로부터 Statement 구현체를 얻는다.
		Statement stmt = con.createStatement();
		
		// DBMS에 질의하기
		// 서버에 질의할 insert문
		// insert SE_SUBJS(TITLE, DEST) values('Java기초', '자바 기초 문법 강의')
		stmt.executeUpdate("insert SE_SUBJS(TITLE, DEST) values('Java고급', '자바 스레드, 네트워킹 프로그래밍')");
		
		System.out.println("[강진]오호라.. 연결되었다!");
		
		stmt.close();
		con.close();		// 서버에 연결 종료를 호출한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때까지 연결을 유지한다.
	}

}

// interface 규칙을 따르는 인스턴스를 리턴함.
// 참조 변수를 받을 때는 인터페이스로 받음음로써 
// 소스코드의 종속성을 막을 수 있다.
// 
