package sems.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

@Controller
@RequestMapping("/subject/update")
public class SubjectUpdateControl {
	@Autowired
	SubjectDao subjectDao;
	
	// Get 요청시 호출됨
	@RequestMapping(method=RequestMethod.GET)
	public String updateForm(int no, Model model) {
		try {
				SubjectVo subject = subjectDao.detail(no);
				model.addAttribute("subject", subject);
				return "/subject/updateform.jsp";

		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	// Post 요청시 호출됨
	// 프런트 컨트롤러(DispatcherServlet)이 vo 객체를 만드는 게 아니라 외주줄거야.
	// value(vo)는 프런트 컨트롤러가 자동으로 셋터 메서드들을 꼽아준다.
	// setNo, setTitle, setDescription
	// jsp 입력폼에서 파라미터 이름이 아래 vo와 같아야 꼽아준다.
	@RequestMapping(method=RequestMethod.POST)
	public String update(SubjectVo vo, Model model) {
		try {
				subjectDao.update(vo);
				return "redirect:detail.bit?no=" + vo.getNo();

		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
