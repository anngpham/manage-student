package communityuni.com.model;

public class Student implements Comparable<Student> {
	public String name;
	public String id;
	public double gpa;

	public Student(String name, String id, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	public String getRank() {
		if (gpa > 8.0)
			return "Excellent";
		if (gpa > 6.5)
			return "Good";
		if (gpa > 5.0)
			return "Medium";
		return "Weak";
	}

	@Override
	public int compareTo(Student o) {
		if (this.gpa > o.gpa)
			return -1;
		if (this.gpa == o.gpa)
			return 0;
		return 1;
	}

	@Override
	public String toString() {
		return this.name + " " + this.id + " " + Double.toString(this.gpa);
	}

	public String toLine() {
		return this.name + ";" + this.id + ";" + Double.toString(this.gpa);
	}

	public static Student plainToInstance(String line) {
		Student student = null;
		String[] arr = line.split(";");
		if (arr.length == 3) {
			String studentName = arr[0];
			String studentId = arr[1];
			double studentGpa = Double.parseDouble(arr[2]);
			student = new Student(studentName, studentId, studentGpa);
		}
		return student;
	}
}
