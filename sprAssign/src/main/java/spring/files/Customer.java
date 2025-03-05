package spring.files;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq2")
	@SequenceGenerator(name = "cusseq2", sequenceName = "cus_seq1", allocationSize = 1)
	private int cid;
	private String cname;
	private int age;
	private String address;
	private String permaddress;
	
	@OneToMany(targetEntity = Order.class, mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders;
	
	public Customer() {}

	public Customer(String cname, int age, String address, String permaddress) {
		this.cname = cname;
		this.age = age;
		this.address = address;
		this.permaddress = permaddress;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
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
