package elosztott.me.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class MessageActivator {
	
	@Autowired
	private SendCourses courses;
	
	public ExecutionReport activate(Message<CourseModel> message) {
		CourseModel course = message.getPayload();
		System.out.println(course);
		if(course==null){
			return generateError("course not found!");
		}
		return new ExecutionReport("course successfully added", course);
	}
	
	private ExecutionReport generateError(String error){
		return new ExecutionReport(error,false);
	}

}
