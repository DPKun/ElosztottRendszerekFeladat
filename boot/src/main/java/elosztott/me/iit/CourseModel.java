package elosztott.me.iit;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CourseModel {

	@NotBlank
	@Length(min = 3, max = 100)
	private String courseName;
	
	@Min(1)
	private int courseCredit;
	
	@Min(1)
	private int preferredSemester;

	public CourseModel() {
		super();
	}

	public CourseModel(String courseName, int courseCredit, int preferedSemester) {
		super();
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.preferredSemester = preferedSemester;
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

	public int getPreferredSemester() {
		return preferredSemester;
	}

	public void setPreferredSemester(int preferedSemester) {
		this.preferredSemester = preferedSemester;
	}

	@Override
	public String toString() {
		return "CourseModel [courseName=" + courseName + ", courseCredit=" + courseCredit + ", preferedSemester="
				+ preferredSemester + "]";
	}

}
