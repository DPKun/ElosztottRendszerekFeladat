package elosztott.me.iit;

import lombok.Data;

@Data
public class CreateCourseDTO {

	private String courseName;
	private int courseCredit;
	private int preferedSemester;
	public CreateCourseDTO() {
		super();
	}
	public CreateCourseDTO(String courseName, int courseCredit, int preferedSemester) {
		super();
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.preferedSemester = preferedSemester;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public int getPreferedSemester() {
		return preferedSemester;
	}
	public void setPreferedSemester(int preferedSemester) {
		this.preferedSemester = preferedSemester;
	}
	
	
	
}
