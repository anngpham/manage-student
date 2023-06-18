package communityuni.com.model;

import java.util.HashMap;

public class Student implements Comparable<Student> {
	public String name;
	public String id;
	public double gpa;

	private static final HashMap<Rank, String> RANK_CONFIG = new HashMap<Rank, String>() {
		{
			put(Rank.EXECLLENT, "Xuat sac");
			put(Rank.GOOD, "Gioi");
			put(Rank.MEDIUM, "Trung binh");
			put(Rank.WEAK, "Yeu");
		}
	};

	public Student(String name, String id, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	public Rank getRank() {
		if (gpa > 8.0)
			return Rank.EXECLLENT;
		if (gpa > 6.5)
			return Rank.GOOD;
		if (gpa > 5.0)
			return Rank.MEDIUM;
		return Rank.WEAK;
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
		return this.name + " " + this.id + " " + Double.toString(this.gpa) + " " + RANK_CONFIG.get(this.getRank());
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
