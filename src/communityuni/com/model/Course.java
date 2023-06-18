package communityuni.com.model;

import java.util.ArrayList;

public class Course {
	public String name;
	public String id;
	public String teacherId;

	public Course(String name, String id, String teacherId) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return this.name + " " + this.id;
	}

	public String getTeacherName(ArrayList<Teacher> teacherList) {
		for (Teacher teacher : teacherList) {
			if (teacher.id.equals(this.teacherId))
				return teacher.name;
		}
		throw new Error("Error data in teacherList");
	}

	public String toLine() {
		return this.name + ";" + this.id + ";" + this.teacherId;
	}

	public static Course plainToInstance(String line) {
		Course course = null;
		String[] arr = line.split(";");
		if (arr.length == 3) {
			String courseName = arr[0];
			String courseId = arr[1];
			String teacherId = arr[2];
			course = new Course(courseName, courseId, teacherId);
		}
		return course;
	}
}
