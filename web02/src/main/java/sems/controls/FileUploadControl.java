package sems.controls;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/upload")
public class FileUploadControl {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping
	public String execute(
			String name,
			int age,
			@RequestParam("file1") MultipartFile file1,
			Model model) {
		try {
			// 파일 데이터 저장
  		// 저장위치: {톰캣서버의 배치폴더}/웹애플리케이션/upload/
  		String fullPath = servletContext.getRealPath("/upload");
  		
  		if (!file1.isEmpty()) {
  			String filename = System.currentTimeMillis() + "_" + ++fileCount;
  			
  			// savedFile 정보에 따라 해당 경로에 파일 저장
  			File savedFile = new File(fullPath + "/" + filename);
  			System.out.println("saveFile:" + savedFile);
  			file1.transferTo(savedFile);
  			
  			model.addAttribute("name", name);
  			model.addAttribute("age", age);
  			model.addAttribute("file1name", filename);
  		}
  		
			return "/file/uploadResult.jsp";
					
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
