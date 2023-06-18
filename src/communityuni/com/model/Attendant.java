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

	public String toLine() {
		return this.courseId + ";" + this.studentId;
	}

	public static Attendant plainToInstance(String line) {
		Attendant attendant = null;
		String[] arr = line.split(";");
		if (arr.length == 2) {
			String studentId = arr[0];
			String courseId = arr[1];
			attendant = new Attendant(studentId, courseId);
		}
		return attendant;
	}
}
