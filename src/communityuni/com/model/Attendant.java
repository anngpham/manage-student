package communityuni.com.model;

import java.util.ArrayList;

public class Attendant {
	public String studentId;
	public String courseId;
	private String studentName;
	private String courseName;

	public Attendant(String studentId, String courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public String getStudentName(ArrayList<Student> studentList) {
		if (this.studentName != null) {
			return this.studentName;
		}

		for (Student student : studentList) {
			if (student.id.equals(this.studentId)) {
				this.studentName = student.name;
				return student.name;
			}
		}
		
		throw new Error("Error data in studentList");
	}

	public String getCourseName(ArrayList<Course> courseList) {
		if (this.courseName != null) {
			return this.courseName;
		}

		for (Course course : courseList) {
			if (course.id.equals(this.courseId)) {
				this.courseName = course.name;
				return course.name;
			}
		}

		throw new Error("Error data in courseList");
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
