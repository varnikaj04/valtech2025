

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	private int oid;
	private int cid;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		PACKED, ONTHEWAY, DELIVERED, NOTDELIVERED;
	}

	public Order() {}

	public Order(int oid, int cid, Status status) {
		super();
		this.oid = oid;
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
