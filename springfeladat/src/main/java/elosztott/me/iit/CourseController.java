package elosztott.me.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
	@Autowired
	CourseManager courseManager;
	
	
	@RequestMapping(value={"","/"})
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("index");
		return model;
		
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView welcome(){
		ModelAndView model = new ModelAndView("welcomepage");
		CourseModel course = new CourseModel("Analizis", 5, 1);
		courseManager.addCourse(course);
		model.addObject("course",courseManager.getFirstCourse());
		return model;
		
	}
	

}
