package spring.files;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordseq")
	@SequenceGenerator(name = "ordseq", sequenceName = "ord_seq", allocationSize = 1)
	private int oid;
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id", referencedColumnName = "cust-id")
	private int cid;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		PACKED, ONTHEWAY, DELIVERED, NOTDELIVERED;
	}

	public Order() {}

	public Order( int cid, Status status) {
		this.cid = cid;
		this.status = status;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", status=" + status + "]";
	}
	
	
	
}
