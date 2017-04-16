package elosztott.me.iit;


public interface SendCourses {
	
	public void send(CourseModel course);
	
	public Object receive();
	
	public void send(String message);

}
