package communityuni.com;

public class sv {
	private String name;
	private String id;
	private double dtb;
	public sv(String name, String id, double dtb) {
		super();
		this.name = name;
		this.id = id;
		this.dtb = dtb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
	public String getXepLoai()
	{
		if(dtb > 8.0) return "Gioi";
		else if(dtb > 6.5) return "Kha";
		else if(dtb > 5.0) return "Trung Binh";
		else return "Yeu";
	}

}
