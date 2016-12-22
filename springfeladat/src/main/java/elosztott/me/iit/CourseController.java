package elosztott.me.iit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		//courseManager.clearCourses();
		ModelAndView model = new ModelAndView("welcomepage");
		//CourseModel course = new CourseModel("Analizis", 5, 1);
		//courseManager.addCourse(course);
		//CourseModel course2 = new CourseModel("Progalap", 5, 1);
	//	CourseModel course3 = new CourseModel("Dimat", 5, 1);
	//.addCourse(course2);
	//	courseManager.addCourse(course3);
		model.addObject("courses", courseManager.getCourses());
		
		return model;
		
	}
	
	@RequestMapping(value="/rest")
	public ModelAndView rest(){
		ModelAndView model = new ModelAndView("rest");
		return model;
		
	}
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.GET)
	public String newUser(){
		return "addCourse";
	}
	
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.POST)
	public ModelAndView newCoursePost(@ModelAttribute() CreateCourseDTO newCourseRequest){
		if(newCourseRequest.getCourseName().trim().length()==0){
			ModelAndView mav = new ModelAndView("addCourse");
			mav.addObject("message", "Not valid courseName");
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("redirect:/welcome");
			courseManager.addCourse(new CourseModel(newCourseRequest.getCourseName(), newCourseRequest.getCourseCredit(), newCourseRequest.getPreferedSemester()));
			mav.addObject("users", courseManager.getCourses());
			return mav;
		}
		}

	

}
