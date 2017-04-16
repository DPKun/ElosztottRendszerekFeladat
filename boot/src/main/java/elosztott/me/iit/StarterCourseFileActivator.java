package elosztott.me.iit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class StarterCourseFileActivator {

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
			FileWriter fileStarterWriter = new FileWriter("StarterCourses.txt", true);
			BufferedWriter fileStarter = new BufferedWriter(fileStarterWriter);
			fileStarter.append(course.getCourseName()+","+course.getCourseCredit());
			fileStarter.newLine();
			fileStarter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private ExecutionReport generateError(String error){
		return new ExecutionReport(error,true);
	}
}
