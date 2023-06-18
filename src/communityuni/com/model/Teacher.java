package communityuni.com.model;

public class Teacher {
	public String name;
	public String id;

	public Teacher(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String toLine() {
		return this.name + ";" + this.id;
	}

	public static Teacher plainToInstance(String line) {
		Teacher teacher = null;
		String[] arr = line.split(";");
		if (arr.length == 2) {
			String teacherId = arr[0];
			String teacherName = arr[1];
			teacher = new Teacher(teacherName, teacherId);
		}
		return teacher;
	}
}
