package sems.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

// 이 URL(/subject/detail)은 이 객체에서 처리해
// 이 때 매핑되는 메서드는 execute() 메서드야.
@Controller
@RequestMapping("/subject/detail")
public class SubjectDetailControl {
	@Autowired
	SubjectDao subjectDao;
	
	@RequestMapping
	public String execute(int no, Model model) {
    try {
    	SubjectVo subject = subjectDao.detail(no);
	    model.addAttribute("subject", subject);
	    return "/subject/detail.jsp";
	    
    } catch (Throwable ex) {
	    throw new Error(ex);
    }
	}

}
