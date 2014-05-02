package sems.controls;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

/* 페이지 컨트롤러에 애노테이션 붙이기
 *  @Component: 일반 객체에 붙이는 용도로 주로 사용
 *  @Controller: 페이지 컨트롤러에 붙인다.
 *  @Servlet: 비즈니스 로직을 수행하는 서비스 역할 객체에게 붙인다.
 *  @Repository: DAO 객체에 붙인다.
 *  객체의 역할 별로 구분해서 애노테이션을 붙이면
 *  클래스의 역할을 빠르게 파악할 수 있어서 좋다.
 * 
 *  @Component("/subject/list.bit")
 */
// @RequestParam 애노테이션 사용
@Controller
public class SubjectListControl {
	
	static Logger log = Logger.getLogger(SubjectListControl.class);
	
	@Autowired
	SubjectDao subjectDao;
	
	public SubjectListControl() {
		log.debug("SubjectListControl 생성됨");
	}

	// Model : 결과를 저장할 바구니
	/* 스프링 MVC 프레임워크 규칙에 다라 페이지 컨트롤러 만들기
	 *  1) 호출될 메서드는 @RequestMapping 으로 선언한다.
	 *  2) 요청 파라미터 값을 꺼내야 한다면, 메서드의 파라미터로 선언한다.
	 *  	- 문자열이 기본 타입(byte,short,int,long,float,double,boolean,char)
	 *  	  으로 자동 변환된다.
	 *  3) 작업한 결과를 리턴하고 싶다면, Model 객체를 파라미터로 요구하라!
	 * 
	 * DispatherServlet 프런트 컨트롤러는 이 메서드를 호출할 때
	 *  원하는 대로 요청 파라미터 값을 꺼내서 넘겨준다.
	 *  그리고 작업 결과를 리턴 받기 위해 Map 객체를 건넨다.
	 */
	
	// @RequestParam("요청파라미터명")
	//  - 메서드의 파라미터와 요청 파라미터를 연결하는 애노테이션
	//  - 만약 메서드의 파라미터 이름과 요청 파라미터 이름이 같다면 생략 가능
	//  - @RequestParam("pageNo") int pageNo 임
	//    @RequestParam(value="pageNo",  required=false, defaultValue="1") int pageNo,
	//    @RequestParam(value="pageNo",  defaultValue="1") int pageNo,
	//	- required : 필수 파라미터 여부 (URL에서 생략 가능하면 false로 하고, defaultValue를 주자)
	//	- defaultValue : 요청 파라미터가 없을 때 사용할 기본 값
	@RequestMapping("subject/list")
//public String execute(int pageNo, int pageSize, Model model) {
	public String execute(
			@RequestParam(value="pageNo",  defaultValue="1") int pageNo,
			@RequestParam(value="pageSize",defaultValue="10") int pageSize,
			Model model) {
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("startIndex", (pageNo - 1) * pageSize);
			params.put("pageSize", pageSize);
			
			List<SubjectVo> list = subjectDao.list(params);
			model.addAttribute("list", list);
			return "/subject/list.jsp";
			
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
}
