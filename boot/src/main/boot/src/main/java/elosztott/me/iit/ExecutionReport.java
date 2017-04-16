package elosztott.me.iit;

public class ExecutionReport {

	private String message;
	private CourseModel course;
	private boolean starter;
	
	public ExecutionReport(){
		
	}

	
	public boolean isStarter() {
		return starter;
	}


	public void setStarter(boolean starter) {
		this.starter = starter;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}

	public ExecutionReport(String message, CourseModel course) {
		super();
		this.message = message;
		this.course = course;
		if(course.getPreferredSemester()==1){
			starter=true;
		}else{
			starter=false;
		}
	}
	
	public ExecutionReport(String message, boolean starter) {
		super();
		this.message = message;
		this.starter=starter;
		this.course = null;
	}

	@Override
	public String toString() {
		return "ExecutionReport: [Message=" + message + ", course=" + course + "]";
	}
	
	
}
