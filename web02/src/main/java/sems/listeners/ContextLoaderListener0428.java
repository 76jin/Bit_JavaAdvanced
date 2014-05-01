/*package sems.listeners;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.reflections.Reflections;

import sems.annotations.Component;


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
 * 	- 애플리케이션에서 직접 관리하지 않고, 서블릿 컨테이너에서 관리한다.
 * 	- 사용 방법
 * 		1) 서블릿 컨테이너에 DataSource 객체 설정
 * 		2) 웹 애플리케이션 설정(web.xml)에서 서블릿 컨테이너의 DataSource를 참조.
 * 
 * web.xml에 설정된 자원을 가져오는 방법
 * 	예) DataSource를 꺼내는 방법
 * 		- InintialContext 객체를 준비 <= 서버의 자원을 가져오는 역할 수행
 * 		- lookup(자원이름) 호출
 

 Bean 자동 생성 - 애노테이션 이용하기
 * 
 * 1) WEB-INF/classes 폴더에 있는 클래스들 중에서
 * 	@Component 애노테이션이 붙은 클래스를 찾는다.
 * 2) 그 클래스의 인스턴스를 생성하여 objPool에 담는다.
 * 3) 나머지는 이전과 같다.
 
public class ContextLoaderListener0428 implements ServletContextListener {
	
	Logger log = Logger.getLogger(ContextLoaderListener0428.class);
	
	ServletContext sc;
	
	//생성된 객체를 임시 보관할 저장소
	// 여러 인스턴스 메서드에서 objPool을 사용한다면,
	// 차라리 인스턴스 변수로 만든다.
	HashMap<String,Object> objPool = new HashMap<String,Object>();

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.debug("contextDestroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("contextInitialized...");
		
		// ServletContext: 웹 어플리케이션이 생성되서 종료할 때까지 유지되는 보관소임.
		sc = event.getServletContext();
		
		try {
			// DataSource 가져오기
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/studydb"); // web.xml의 name 사용

			// 임시 저장소에 객체 보관
			objPool.put("dataSource", ds);
			objPool.put("servletContext", sc);	// 서블릿 컨텍스트도 미리 저장

			// .properties 파일을 읽어서 빈을 생성한다.
			// @ 애노테이션이 붙은 클래스를 찾아 빈을 생성한다.
			preparedBeansFromAnnotation();

			// objPool에 들어있는 빈에 대해 의존 객체를 찾아 주입한다.
			injectDependencies();
			
			// 임시 보관소에 저장된 객체들을 ServletContext에 복사한다.
			//	- DispaytcherSerlvet이 페이지 컨트롤러를 찾을 수 있도록 하기 위함.
			for (Entry<String,Object> entry : objPool.entrySet()) {
				sc.setAttribute(entry.getKey(), entry.getValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

	 preparedBeansFromProperties()
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
	  

	private void preparedBeansFromAnnotation()
		throws Exception{
		
		Reflections reflections = new Reflections("sems.dao");
		reflections.merge(new Reflections("sems.controls"));
		Component compAnno = null; 
		String compName = null;
		
		for (Class<?> clazz : 
			reflections.getTypesAnnotatedWith(Component.class)) {
			compAnno = clazz.getAnnotation(Component.class);
			compName = compAnno.value();
			if (compName.equals("")) {
				compName = clazz.getName();
			}
			
			objPool.put(compName, clazz.newInstance());
			
		}
  }
	
	private void findAndCreateComponent(File dir, String packageName) throws Exception {
		File[] files = dir.listFiles(); 	// 하위 폴더 및 파일 목록 리턴
		int index = 0;
		String className = null;	// 패키지 이름을 포함한 이름
		Class<?> clazz = null;
		String compname= null; // objPool에 저장할 때 사용할 이름
		
		for (File f : files) {
			if (f.isDirectory()) {
				findAndCreateComponent(f, packageName + f.getName() + ".");
			} else { // only file
				if (f.getName().endsWith(".class")) { // only .class file
					// WEB-INF/classes/controls/SubjectListControl.class
					// -> controls.SubjectListControl.class
					// -> controls/SubjectListControl
					
					// .class가 시작되는 인덱스 알아내기
					index = f.getName().indexOf(".class");
					className = packageName + f.getName().substring(0, index);
					log.debug(className);
					
					// 1) 클래스 로딩
					clazz = Class.forName(className);
					
					// 2) @Component 애노테이션이 있는지 여부 조사
					// java에서는 컴파일 되면, interface, class, Annotation 모두 class라고 여긴다.
					Component compAnno = (Component) clazz.getAnnotation(Component.class);
					if (compAnno != null) {
						log.debug("******" + className);
						compname = compAnno.value();		// @Component(이름)
						if (compname.equals("")) {			// @Component <- 이름이 없다면
							compname = className;					// 클래스 이름을 객체 이름을 사용함.
						}
						
						// 빈을 생성하여 임시 저장소에 보관한다.
						objPool.put(compname, clazz.newInstance());
						log.info("\tcreated: " + compname + "[" + className + "]");
						
					}
					
				}
			}
		}
	  
  }

	// objPool에서 clazz와 같은 게 있는 찾아서 넘겨 준다.
  private Object findDependency(Class<?> clazz) throws Exception {
		for (Object dependency : objPool.values()) {
			if (clazz.isInstance(dependency) ) {	// dependency가 clazz의 인스턴스인지 확인
				return dependency;
			}
		}
		
		return null;
	}

	private void injectDependencies()
		throws Exception {
		// objPool에서 빈을 꺼내어 setXXX() 메서드를 찾는다.
		Class<?> clazz = null;
		Object dependency = null;
		for (Object obj : objPool.values()) {
			log.error("ERROR: " + obj);
			clazz = obj.getClass();	// 객체의 클래스 정보를 가져온다.
			log.debug("00000 " + clazz.getName());
			
			// 셋터 메서드를 찾는다.
			for (Method m : clazz.getMethods()) {
				if (m.getName().startsWith("set")) {
					log.debug("==>" + m.getName());
					
					// 셋터 메서드의 파라미터 타입을 알아낸다. => 의존 객체 찾는다.
					log.error("getParameterTypes " + m.getParameterTypes()[0]);
					dependency = findDependency(m.getParameterTypes()[0]);
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