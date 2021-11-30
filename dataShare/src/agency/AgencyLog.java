package agency;

public class AgencyLog {
	private String id;
	private String name;
	private int data;
	private String day;
	private String agency;
	private String type;
	private int fee;
	
	public AgencyLog(String id, String name, int data, String day, String agency, String type, int fee) {
		this.id = id;
		this.name = name;
		this.data = data;
		this.day = day;
		this.agency = agency;
		this.type = type;
		this.fee = fee;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "AgencyLog [id=" + id + ", name=" + name + ", data=" + data + ", day=" + day + ", agency=" + agency
				+ ", fee=" + fee + "]";
	}
	
}
