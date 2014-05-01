package sems.controls.auth;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutControl {
	
	HttpSession session;
	
	public void setSession(HttpSession session) {
		this.session = session;
	}

	@RequestMapping("/auth/logout")
	public String execute(HttpSession session) {
		
		session.invalidate();
		return "redirect:login.bit";
		
	}

}
