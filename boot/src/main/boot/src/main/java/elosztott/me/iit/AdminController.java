package elosztott.me.iit;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class AdminController{
	
	@Autowired
	CourseManager courseManager;
	
	@Autowired
	SendCourses sendCourses;
	
	private String[] fields = new String[] { "courseName", "courseCredit", "preferredSemester" };
	
	
	@RequestMapping(value={"","/","/welcome"})
	public ModelAndView welcome(){
		ModelAndView model = new ModelAndView("welcomepage");
		model.addObject("courses", courseManager.getCourses());
		return model;
	}
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.GET)
	public ModelAndView newCourse(){
		ModelAndView mav = new ModelAndView("addCourse");
		mav.addObject("CourseModel", new CourseModel());
		return mav;
	}
	
	
	@RequestMapping(value = "/addCourse", method=RequestMethod.POST)
	public ModelAndView newCoursePost(@ModelAttribute("CourseModel") @Valid CourseModel newCourseRequest, BindingResult validationresult){
		List<String> errors = new ArrayList<String>();
		if(validationresult.hasErrors()){
			ModelAndView mav = new ModelAndView("addCourse");
			manageErrors(errors, fields, validationresult);
			mav.addObject("errors", errors);
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView("redirect:/welcome");
			courseManager.addCourse(new CourseModel(newCourseRequest.getCourseName(), newCourseRequest.getCourseCredit(), newCourseRequest.getPreferredSemester()));
			mav.addObject("courses", courseManager.getCourses());
			sendCourses.send(newCourseRequest);
			return mav;
		}
		}
	
	private void manageErrors(List<String> result, String[] fields, BindingResult validationResult) {
		int length = fields.length;
		List<FieldError> fieldErrors = null;
		for (int i = 0; i < length; i++) {
			fieldErrors = validationResult.getFieldErrors(fields[i]);
			for (FieldError fe : fieldErrors) {
				result.add(fields[i] + ": " + fe.getDefaultMessage());
			}
		}
	}

}
