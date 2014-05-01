package sems.listeners;
/*package listeners;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import util.DBConnectionPool;

import controls.FileUploadControl;
import controls.SubjectDeleteControl;
import controls.SubjectDetailControl;
import controls.SubjectInsertControl;
import controls.SubjectListControl;
import controls.SubjectUpdateControl;
import controls.auth.LoginControl;
import controls.auth.LogoutControl;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;


 PageController를 ServletContext에 보관함.
 * 	- PageController가 필요로 하는 의존 객체를 주입한 후에 보관한다.
 

 애플리케이션을 실행하는 중에 기록을 남기기
 * 	- 조건에 따라 기록을 남기는 걸 활성화하고 또는 비활성화 시키기
 * 	- logForJava (log4j)
 * 
 * .properties 파일을 이용해 빈 자동 생성 및 의존 객체 자동 주입
 

 DBConnectionPool을 JDBC 공식 커넥션 풀로 대체
 * 	- javax.jdbc.DataSource
 
public class ContextLoaderListener_0425_am implements ServletContextListener {
	
	Logger log = Logger.getLogger(ContextLoaderListener_0425_am.class);
	ServletContext sc;
	DBConnectionPool dbConnectionPool;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.debug("contextDestroyed...");
		dbConnectionPool.closeAll();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("contextInitialized...");
		
		// ServletContext: 웹 어플리케이션이 생성되서 종료할 때까지 유지되는 보관소임.
		sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();

		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		// 생성된 객체를 임시 보관할 저장소
		HashMap<String,Object> objPool = new HashMap<String,Object>();
		objPool.put("dbConnectionPool", dbConnectionPool);
		objPool.put("servletContext", sc);	// 서블릿 컨텍스트도 미리 저장
		
		try {
			// .properties 파일을 읽어서 빈을 생성한다.
			preparedBeansFromProperties(objPool);

			// objPool에 들어있는 빈에 대해 의존 객체를 찾아 주입한다.
			injectDependencies(objPool);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 임시 보관소에 저장된 객체들을 ServletContext에 복사한다.
		//	- DispaytcherSerlvet이 페이지 컨트롤러를 찾을 수 있도록 하기 위함.
		for (Entry<String,Object> entry : objPool.entrySet()) {
			sc.setAttribute(entry.getKey(), entry.getValue());
		}
		
		
		 beans.properties 파일에서 처리하도록 변경함.
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectDao);
		
		MysqlUserDao userDao = new MysqlUserDao();
		userDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userDao);
		
		SubjectListControl subjectListControl = new SubjectListControl();
		subjectListControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/list.bit", subjectListControl);
		
		SubjectDetailControl subjectDetailControl = new SubjectDetailControl();
		subjectDetailControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/detail.bit", subjectDetailControl);
		
		SubjectInsertControl subjectInsertControl = new SubjectInsertControl();
		subjectInsertControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/insert.bit", subjectInsertControl);
		
		SubjectUpdateControl subjectUpdateControl = new SubjectUpdateControl();
		subjectUpdateControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/update.bit", subjectUpdateControl);
		
		SubjectDeleteControl subjectDeleteControl = new SubjectDeleteControl();
		subjectDeleteControl.setSubjectDao(subjectDao);
		sc.setAttribute("/subject/delete.bit", subjectDeleteControl);
		
		LoginControl loginControl = new LoginControl();
		loginControl.setUserDao(userDao);
		sc.setAttribute("/auth/login.bit", loginControl);
		
		LogoutControl logoutControl = new LogoutControl();
		sc.setAttribute("/auth/logout.bit", logoutControl);
		
		FileUploadControl fileUploadControl = new FileUploadControl();
		sc.setAttribute("/file/upload.bit", fileUploadControl);
		

	}


	private void preparedBeansFromProperties(HashMap<String, Object> objPool)
		throws Exception{
		
		// properties 파일이 있는 경로 알아내기 (.../tmp0/wtpwebapps/web01/WEB-INF/classes
		String path = sc.getRealPath("/WEB-INF/classes/beans.properties");
		FileReader propIn = new FileReader(path); // 절대 경로 지정해 줘야 함.
		
		// beans.properties 파일 읽기
		Properties props = new Properties();
		props.load(propIn);
		
		// 프로퍼티 파일에 적혀있는대로 빈을 생성한다.
		// userDao=dao.MysqlUserDao (Fully Qualify Class Name)
		Class<?> clazz = null;				// UserDao, MysqlSubjectList도 될 수 있어서 익명으로 함.
		for (Entry<Object,Object> entry : props.entrySet()) {
			clazz = Class.forName((String)entry.getValue());
			objPool.put( (String)entry.getKey(), clazz.newInstance()); // 클래스 로딩후 담기.
		}
		
  }
	
	// objPool에서 clazz와 같은 게 있는 찾아서 넘겨 준다.
  private Object findDependency(HashMap<String,Object> objPool, Class<?> clazz) throws Exception {
		for (Object dependency : objPool.values()) {
			if (clazz.isInstance(dependency) ) {	// dependency가 clazz의 인스턴스인지 확인
				return dependency;
			}
		}
		
		return null;
	}

	private void injectDependencies(HashMap<String, Object> objPool)
		throws Exception {
		// objPool에서 빈을 꺼내어 setXXX() 메서드를 찾는다.
		Class<?> clazz = null;
		Object dependency = null;
		for (Object obj : objPool.values()) {
			clazz = obj.getClass();	// 객체의 클래스 정보를 가져온다.
			log.debug(clazz.getName());
			
			// 셋터 메서드를 찾는다.
			for (Method m : clazz.getMethods()) {
				if (m.getName().startsWith("set")) {
					log.debug("==>" + m.getName());
					
					// 셋터 메서드의 파라미터 타입을 알아낸다. => 의존 객체 찾는다.
					dependency = findDependency(objPool, m.getParameterTypes()[0]);
					if (dependency != null) {
						// 셋터 메서드 호출 => 의존 객체 주입
						m.invoke(obj, dependency);
						log.debug("  :" + m.getName() + "호출 성공!");
					}
				}
			}  // End for
		}  // End for
		
	}
}
*/