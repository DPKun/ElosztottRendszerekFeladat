package elosztott.me.iit;

public class CourseRouter {

	public String routeDecision(CourseModel course){
		if(course instanceof CourseModel){
			return "sendCourseChannel";
		}else{
			return "sendMessageChannel";
		}
	}
}
