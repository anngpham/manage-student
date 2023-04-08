package communityuni.com.model;

public class Course {
	private String name;
	private String id;
	private String idTeacher;
	public Course( String name,String id, String idTeacher) {
		super();
		this.id = id;
		this.name = name;
		this.idTeacher = idTeacher;
	}
	public Course() {
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

	public String getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(String idTeacher) {
		this.idTeacher = idTeacher;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getId();
	}
	
}
