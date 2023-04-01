package communityuni.com;

public class attendant {
	private String idSv;
	private String idMh;
	public attendant(String idSv, String idMh) {
		super();
		this.idSv = idSv;
		this.idMh = idMh;
	}
	public String getIdSv() {
		return idSv;
	}
	public void setIdSv(String idSv) {
		this.idSv = idSv;
	}
	public String getIdMh() {
		return idMh;
	}
	public void setIdMh(String idMh) {
		this.idMh = idMh;
	}
	
}
