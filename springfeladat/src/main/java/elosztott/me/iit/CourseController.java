package elosztott.me.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
	@Autowired
	CourseManager courseManager;
	

	@RequestMapping(value={"/","/rest"})
	public ModelAndView rest(){
	        ModelAndView model = new ModelAndView("static/html/rest.html");
	        return model;
     
	        }

}
