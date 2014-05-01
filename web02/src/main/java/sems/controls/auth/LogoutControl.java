package sems.controls.auth;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutControl {
	
	static Logger log = Logger.getLogger(LogoutControl.class);
	
	HttpSession session;
	
	public LogoutControl() {
		log.debug("LogoutControl 생성됨");
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}

	@RequestMapping("/auth/logout")
	public String execute(HttpSession session) {
		
		session.invalidate();
		return "redirect:login.bit";
		
	}

}
