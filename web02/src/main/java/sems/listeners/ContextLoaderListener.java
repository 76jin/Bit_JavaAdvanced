package sems.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 스프링 IoC 컨테이너 적용 */
public class ContextLoaderListener implements ServletContextListener {
	
	Logger log = Logger.getLogger(ContextLoaderListener.class);
	
	// Spring IoC 컨테이너 참조 변수
	//  - 공개하는 이유: DispatcherServlet이 사용하게 하려고.
	public static ClassPathXmlApplicationContext applicationContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.debug("contextDestroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("contextInitialized...");
		
		// applicationContext: 웹 어플리케이션이 생성되서 종료할 때까지 유지되는 보관소임.
		applicationContext = 
				new ClassPathXmlApplicationContext("beans.xml");
	}

}
