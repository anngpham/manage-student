package communityuni.com.model;

public class Student implements Comparable<Student>{
	private String name;
	private String id;
	private double gpa;

	public Student() {
	}

	public Student(String name, String id, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGpa() {
		return this.gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getRank()
	{
		if(gpa > 8.0) return "Good";
		else if(gpa > 6.5) return "Rather";
		else if(gpa > 5.0) return "Medium";
		else return "Weak";
	}
	@Override
	public int compareTo(Student o) {
		if(this.gpa > o.gpa) return -1;
		else if(this.gpa == o.gpa) return 0;
		return 1;
	}
	public String toString()
	{
		return this.name + " " + this.id + " " + Double.toString(this.gpa);
	}

}
