package sems.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.dao.SubjectDao;

@Controller
@RequestMapping("/subject")
public class SubjectDeleteControl {
	@Autowired
	SubjectDao subjectDao;
	
	// 파라미터가 1개일 때만 생략가능해서 value 라고 적어줌.
	@RequestMapping(value="/delete", 
			method=RequestMethod.GET)
	public String execute(int no) {
		try {
			subjectDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";

		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}