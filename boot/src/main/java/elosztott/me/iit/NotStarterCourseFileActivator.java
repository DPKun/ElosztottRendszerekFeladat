package elosztott.me.iit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class NotStarterCourseFileActivator {
	@Autowired
	private CourseManager manager;
	
	@Autowired
	private SendCourses courses;
	
	public ExecutionReport putIntoFile(Message<CourseModel> message){
		CourseModel course = message.getPayload();
		
		if(course==null){
			return generateError("No payload to upload");
		}
		
		if(!manager.containsCourse(course)){
			return generateError("No such user found in manager");
		}
		writeToFile(course);
		return new ExecutionReport("Not a starter course!", course);
	}
	
private void writeToFile(CourseModel course) {
		
		try {
			FileWriter fileNotStarter = new FileWriter("NotStarterCourses.txt", true);
			BufferedWriter outputNotStarter = new BufferedWriter(fileNotStarter);
			outputNotStarter.append(course.getCourseName()+","+course.getCourseCredit());
			outputNotStarter.newLine();
			outputNotStarter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private ExecutionReport generateError(String error){
		return new ExecutionReport(error,false);
	}
}
