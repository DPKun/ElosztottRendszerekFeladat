package elosztott.me.iit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class CourseManager implements Serializable{
	/**
	 *  
	 */

	private List<CourseModel> courses = new ArrayList<CourseModel>();
	public void addCourse(CourseModel course){
		courses.add(course);
	}
	public List<CourseModel> getCourses() {
		return courses;
	}
	
	public CourseModel getFirstCourse(){
		if(!courses.isEmpty()){
			return courses.get(0);
		}
		return new CourseModel("Unknown", -1, -1);
	}
	
	public void clearCourses(){
		courses.clear();
	}
	public CourseManager() {
		super();
	}
	
	
	
}