package communityuni.com.model;

public class mh {
	private String name;
	private String id;
	private String idGv;
	public mh( String name,String id, String idGv) {
		super();
		this.id = id;
		this.name = name;
		this.idGv = idGv;
	}
	public mh() {
    }
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdGv() {
		return idGv;
	}
	public void setIdGv(String idGv) {
		this.idGv = idGv;
	}
	@Override
	public String toString() {
		return this.getName() + " " + this.getId();
	}
	
}
