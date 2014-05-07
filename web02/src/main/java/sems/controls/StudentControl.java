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
import sems.services.StudentsService;
import sems.vo.StudentVo;

@Controller
@RequestMapping("/student")
@SessionAttributes("student") // student 이름을 가진 객체는 세션에 저장하라는 명령
															// 세션에 보관될 객체의 이름을 선언
public class StudentControl {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	StudentsService studentService;
	
	// 기본 정보 입력폼 출력
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return "student/insert";
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
		return "student/insert2";
	}
	
	// 추가 정보 입력값 받고 => 전체 입력값 출력
	//  @ModelAttribute("student")
	//	 - 파라미터 값을 세션으로부터 가져와라.
	//	 - 그리고 클라이언트가 보낸 데이터를 이 객체에 넣어라.
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String insert3(@ModelAttribute("student") StudentVo student) {
		return "student/insert3";
	}
	
	// 기존에 입력한 기본 정보와 추가 정보를 DB에 저장
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String insert4(@ModelAttribute("student") StudentVo student) {
		studentService.add(student);
		return "student/insert4";
	}

}
