package spring.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LineItems {

	@Id
	private int lid;
	private int itemid;
	private int quantity;
	private int oid;
	
	public LineItems() {}

	public LineItems(int lid, int itemid, int quantity, int oid) {
		super();
		this.lid = lid;
		this.itemid = itemid;
		this.quantity = quantity;
		this.oid = oid;
	}

	public int getlid() {
		return lid;
	}

	public void setlid(int lid) {
		this.lid = lid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	@Override
	public String toString() {
		return "OrderItems [lid=" + lid + ", itemid=" + itemid + ", quantity=" + quantity + ", oid=" + oid + "]";
	}
	
	
	
}
