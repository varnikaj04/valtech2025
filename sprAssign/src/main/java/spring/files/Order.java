package spring.files;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_info")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordseq")
	@SequenceGenerator(name = "ordseq", sequenceName = "ord_seq", allocationSize = 1)
	private int oid;
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id", referencedColumnName = "cid")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		PACKED, ONTHEWAY, DELIVERED, NOTDELIVERED;
	}
	
	@OneToMany(targetEntity = LineItems.class, cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
	private Set<LineItems> lineItems;

	public Order() {}

	public Order( Status status) {
		this.status = status;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Set<LineItems> getLineItems() {
		return lineItems;
	}
	
	public void setLineItems(Set<LineItems> lineItems) {
		this.lineItems = lineItems;
	}
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
