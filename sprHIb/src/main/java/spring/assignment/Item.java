package spring.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	private int id;
	private String name;
	private String desc;
	private int currentQuan;
	private int reorderQuan;
	private int maxQuan;
	
	public Item() {}

	public Item(int id, String name, String desc, int currentQuan, int reorderQuan, int maxQuan) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.currentQuan = currentQuan;
		this.reorderQuan = reorderQuan;
		this.maxQuan = maxQuan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCurrentQuan() {
		return currentQuan;
	}

	public void setCurrentQuan(int currentQuan) {
		this.currentQuan = currentQuan;
	}

	public int getReorderQuan() {
		return reorderQuan;
	}

	public void setReorderQuan(int reorderQuan) {
		this.reorderQuan = reorderQuan;
	}

	public int getMaxQuan() {
		return maxQuan;
	}

	public void setMaxQuan(int maxQuan) {
		this.maxQuan = maxQuan;
	}

	@Override
	public String toString() {
		return "Item [Id=" + id + ", name=" + name + ", desc=" + desc + ", currentQuan=" + currentQuan
				+ ", reorderQuan=" + reorderQuan + ", maxQuan=" + maxQuan + "]";
	}
	

}
