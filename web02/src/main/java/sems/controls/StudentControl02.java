package sems.controls;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sems.dao.StudentDao;
import sems.dao.UserDao;
import sems.vo.StudentVo;

//@Controller
@RequestMapping("/student")
@SessionAttributes("student") // student 이름을 가진 객체는 세션에 저장하라는 명령
															// 세션에 보관될 객체의 이름을 선언
public class StudentControl02 {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StudentDao studentDao;
	
	// 실제 아래의 인스턴스 변수에 주입되는 객체는 
	// beans.xml에서 설정한 DataSourceTransactionManager 이다.
	@Autowired
	PlatformTransactionManager txManager;
	
	// 기본 정보 입력폼 출력
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return "/student/insert.jsp";
	}
	
	// 기본 정보 입력값 받고 => 추가 정보 입력폼 출력
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String insert2(StudentVo student, Model model) {
		// 모델에 저장하는 객체의 이름이 "student" 이기 때문에 
		// 이 객체는 세션에 보관될 것이다.
		
		// 모델에 저장하는 객체는 기본적으로 ServletRequest에 보관된다.
		// 만약 객체의 이름이 @SessionAttributes에 선언되어 있다면
		// HttpSession에 보관한다.
		model.addAttribute("student", student);
		return "/student/insert2.jsp";
	}
	
	// 추가 정보 입력값 받고 => 전체 입력값 출력
	//  @ModelAttribute("student")
	//	 - 파라미터 값을 세션으로부터 가져와라.
	//	 - 그리고 클라이언트가 보낸 데이터를 이 객체에 넣어라.
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String insert3(@ModelAttribute("student") StudentVo student) {
		return "/student/insert3.jsp";
	}
	
	// 기존에 입력한 기본 정보와 추가 정보를 DB에 저장
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String insert4(@ModelAttribute("student") StudentVo student) {
		// 1. 트랜잭션을 정의한다.
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		
		// 1)트랜잭션의 이름
		def.setName("tx1");
		
		// 2) 트랜잭션 관리 정책 (트랜잭션 반드시 요구됨 정책)
		// 		- Propagation : 전파하다.
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		// 2. 트랜잭션 관리자로부터 트랜잭션 핸들러 얻기
		TransactionStatus status = txManager.getTransaction(def);
		try {
			userDao.insert(student); // StudentVo는 UserVo의 자식이므로 형변환 가능
			studentDao.insert(student);
			
			txManager.commit(status);
			
			return "/student/insert4.jsp";
		} catch (Throwable ex) {
			txManager.rollback(status);
			throw new RuntimeException("학생 정보 입력 오류!", ex);
			// 메서드에 throws를 선언하지 않아도 이 예외를 DispatcherServlet에게 전달한다.
		}
		
		
	}

}
