package communityuni.com.model;

import java.util.ArrayList;

public class Attendant {
	public String studentId;
	public String courseId;

	public Attendant(String studentId, String courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public String getStudentName(ArrayList<Student> studentList) {
		for (Student student : studentList) {
			if (student.id.equals(this.studentId))
				return student.name;
		}
		throw new Error("Error data in studentList");
	}

}
