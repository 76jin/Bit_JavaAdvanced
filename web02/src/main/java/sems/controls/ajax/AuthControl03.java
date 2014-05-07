package sems.controls.ajax;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.UserDao;
import sems.services.AuthService;
import sems.services.UserGroup;
import sems.vo.AjaxResult;
import sems.vo.UserVo;

import com.google.gson.Gson;

//@Controller
//@RequestMapping("/auth")
public class AuthControl03 {
	
	static Logger log = Logger.getLogger(AuthControl03.class);
	
	@Autowired
	AuthService authService;
	
	@Autowired
	UserDao userDao;
	
	// 리턴값이 문자열이고 URL이라면 원래대로 동작함.
	// => viewResulver를 실행함.
	// 리턴타입이 HttpEntity 라면, viewResulver를 실행하지 않는다.
	// => 이 pageController에서 직접 컨텐츠를 리턴하겠다는 의미라고 함.
	
	/* 리턴 타입이 HttpEntity 인 경우, JSP를 include하지 않고,
	 *  HttpEntity의 내용을 클라이언트로 보낸다.
	 *   => JSP를 안들어도 된다.
	 */
	@RequestMapping("/login")
	public HttpEntity<String> login(
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response,
			Model model) {	 									// 로그인 수행, 파라미터는 프런트 컨트롤러가 알아서 꼽아줌
		try {
			
			System.out.println("saveEmail: " + saveEmail);
			System.out.println("password: " + password);

			UserVo userVo = authService.getLoginUser(email, password, UserGroup.STUDENT);
			
			AjaxResult result = null;

			if (userVo == null) {
				result = new AjaxResult().setStatus("ok").setData("failure");
			} else {
				result = new AjaxResult().setStatus("ok").setData("success");

				// 로그인 성공인 경우 처리
				session.setAttribute("loginUser", userVo);

				if (saveEmail.equals("true")) {
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("s24.java48.com");		// 서버 범위
					cookie.setPath("/web02");							// 서버의 하위 폴더 범위
					//cookie.setMaxAge(40);               // 유효기간 지정 : 40초

					response.addCookie(cookie);
				}
			}
			
			response.setContentType("text/plain;charset=UTF-8");
			
			return new HttpEntity<String>(new Gson().toJson(result));
			
			/* 위와 동작 동일함.
			HttpHeaders resHeaders = new HttpHeaders();
			resHeaders.add("Content-type",  "text/plain;charset=UTF-8");
			return new HttpEntity<String>(
					new Gson().toJson(result), resHeaders);
			*/

		} catch (Throwable ex) {
			throw new Error(ex);
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:login.bit";
		
	}

}
