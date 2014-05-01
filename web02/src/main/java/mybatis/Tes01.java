package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sems.vo.SubjectVo;

public class Tes01 {

	public static void main(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession(true); // Auto commit to DB
		
		sqlSession.delete("test.subject.delete", 118);
		
		System.out.println("삭제 완료!");
		
		sqlSession.close();
	}
	
	public static void main04(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		
		// autocommit
		// - DML(insert, update, delete) 실행 결과를 즉시 DB에 반영하기
		SqlSession sqlSession = factory.openSession(true); // Auto commit to DB
		
		SubjectVo vo = new SubjectVo()
										.setNo(118)
										.setTitle("aaaa121xxxx")
										.setDescription("aaaa121xxxx");
		
		sqlSession.update("test.subject.update", vo);
		
		System.out.println("변경 완료!");
		
		sqlSession.close();
	}
	
	public static void main03(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		// 121 : int 를 Integer로 Auto-boxsing 해줌.
		SubjectVo vo = sqlSession.selectOne("test.subject.detail", 118);
		
		System.out.format("%1$3d %2$s\n%3$s",
				vo.getNo(), vo.getTitle(), vo.getDescription());
		
		sqlSession.close();
	}
	
	public static void main02(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		// SqlSession 객체를 통해 데이터베이스에 질의한다.
		//  - 파라미터 값은 SQL 파일에 있는 특정 SQL 문의 아이디 값이다.
		SubjectVo vo = new SubjectVo()
										.setTitle("aaaa121")
										.setDescription("aaaa121");
		
		// test.subject : 네임스페이스
		// test.subject.insert : namespace이름 + sql 아이디, 파라미터
		// 파라미터 여러 개 안됨. 하나의 객체에 담아서 파라미터 하나로 넘겨야 함.
		sqlSession.insert("test.subject.insert", vo);
		sqlSession.commit();
		
		System.out.println("입력 완료!");
		
		sqlSession.close();
	}
	
	public static void main01(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		// SqlSession 객체를 통해 데이터베이스에 질의한다.
		//  - 파라미터 값은 SQL 파일에 있는 특정 SQL 문의 아이디 값이다.
		List<SubjectVo> list = sqlSession.selectList("test.subject.list");
		
		for (SubjectVo vo : list) {
			System.out.println(vo.getNo() + "," + vo.getTitle());
		}
		
		sqlSession.close();
	}

}
