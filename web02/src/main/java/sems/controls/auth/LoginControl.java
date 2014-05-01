package sems.controls.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.controls.PageController;
import sems.dao.DaoException;
import sems.dao.UserDao;
import sems.vo.UserVo;

@Controller
@RequestMapping("/auth/login")
public class LoginControl {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {		// 로그인 폼 출력
		return "/auth/login.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String execute(
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response) {	 // 로그인 수행, 파라미터는 프런트 컨트롤러가 알아서 꼽아줌
		try {
				UserVo userVo = null;
				try {
					userVo = userDao.getUser(email, password);
					
				} catch (DaoException e) {		// 로그인 실패!
					return "redirect:login.bit";
				}
				
				// 로그인 성공인 경우 처리
				session.setAttribute("loginUser", userVo);
				
				if (saveEmail != null) {
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("s24.java48.com");		// 서버 범위
					cookie.setPath("/web02");							// 서버의 하위 폴더 범위
					//cookie.setMaxAge(40);               // 유효기간 지정 : 40초
					
					response.addCookie(cookie);
				}
				
				return "redirect:../subject/list.bit?pageNo=1&pageSize=10";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
		
	}

}
