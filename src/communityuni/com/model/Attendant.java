package communityuni.com.model;

public class Attendant {
	private String idStudent;
	private String idCourse;
	public Attendant(String idStudent, String idCourse) {
		super();
		this.idStudent = idStudent;
		this.idCourse = idCourse;
	}
	public Attendant() {
    }
    public String getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	public String getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}
	
}
