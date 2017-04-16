package elosztott.me.iit;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class CourseFilter implements MessageSelector {

	@Override
	public boolean accept(Message<?> arg0) {
		if(arg0.getPayload() instanceof CourseModel){
			CourseModel course = (CourseModel) arg0.getPayload();
			if(course.getCourseName() != null && !course.getCourseName().trim().equals("")){
				if(course.getPreferredSemester()==1){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

}
