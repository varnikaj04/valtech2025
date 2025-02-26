

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq")
	private int cid;
	private String cname;
	private int age;
	private String address;
	private String permaddress;
	
	public Customer() {}

	public Customer(int cid, String cname, int age, String address, String permaddress) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.age = age;
		this.address = address;
		this.permaddress = permaddress;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermaddress() {
		return permaddress;
	}

	public void setPermaddress(String permaddress) {
		this.permaddress = permaddress;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", age=" + age + ", address=" + address + ", permaddress="
				+ permaddress + "]";
	}
	
	
	
	
	

}
