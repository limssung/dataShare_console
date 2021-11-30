package agency;

public class AgencySkt {
	private String id;
	private String password;
	private String name;
	private String hpNumber;
	private int data;
	private int fee;

	public AgencySkt(String id, String password, String name, String hpNumber, int data, int fee) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.hpNumber = hpNumber;
		this.data = data;
		this.fee = fee;
	}

	public AgencySkt(String id) {
		this.id = id;
		this.hpNumber = id;
	}

	public AgencySkt(String id, String name, String hpNumber, int data, int fee) {
		this.id = id;
		this.name = name;
		this.hpNumber = hpNumber;
		this.data = data;
		this.fee = fee;
	}

	public AgencySkt(String id, String password, int data) {
		this.id = id;
		this.password = password;
		this.hpNumber = password;
		this.data = data;
	}

	public AgencySkt(String hpNumber, int data) {
		this.hpNumber = hpNumber;
		this.id = hpNumber;
		this.data = data;
	}

	public AgencySkt(String name, String hpNumber) {
		this.name = name;
		this.hpNumber = hpNumber;
		
		this.id = name;
		this.password = hpNumber;
	}

	public AgencySkt(String id, String name, String hpNumber) {
		this.id = id;
		this.name = name;
		this.hpNumber = hpNumber;
		this.password = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHpNumber() {
		return hpNumber;
	}

	public void setHpNumber(String hpNumber) {
		this.hpNumber = hpNumber;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee += fee * 20;
	}

	@Override
	public String toString() {
		return "AgencySKT [id=" + id + ", password=" + password + ", name=" + name + ", hpNumber=" + hpNumber
				+ ", data=" + data + ", fee=" + fee + "]";
	}

}