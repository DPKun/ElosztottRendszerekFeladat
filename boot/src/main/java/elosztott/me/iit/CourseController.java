package elosztott.me.iit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
	@Autowired
	CourseManager courseManager;
	
	List<CourseModel> courses = new ArrayList<>();
	
	private String[] fields = new String[] { "courseName", "courseCredit", "preferredSemester" };
	
	@RequestMapping(value={"/login"})
	public ModelAndView login(){
		ModelAndView model = new ModelAndView("login");
		System.out.println("LOGIN page");
		return model;
	}
	
	@RequestMapping(value={"","/","/welcome"})
	public ModelAndView welcome(){
		ModelAndView model = new ModelAndView("welcomepage");
		model.addObject("courses", courseManager.getCourses());
		return model;
	}
	
/*	@RequestMapping(value={"","/"})
	public ModelAndView base(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("courses", courseManager.getCourses());
		return model;
	}*/
	
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam("course") int course){
		courseManager.removeCourse(course);
		ModelAndView mav = new ModelAndView("welcomepage");
		mav.addObject("courses", courseManager.getCourses());
		return mav;
	}
	
	@RequestMapping(value="/subscribe")
	public ModelAndView subscribeCourse(@RequestParam("course") int course){
		courses.add(courseManager.getCourses().get(course));
		ModelAndView mav = new ModelAndView("welcomepage");
		mav.addObject("courses", courseManager.getCourses());
		return mav;
	}
	
	@RequestMapping(value="/display")
	public ModelAndView displayCourses(){
		ModelAndView mav = new ModelAndView("subscriptions");
		mav.addObject("courses", courses);
		return mav;
	}
	
	@RequestMapping(value="/denied")
	public ModelAndView deny(){
		ModelAndView mav = new ModelAndView("denied");
		return mav;
	}
	
	
	
	
}
