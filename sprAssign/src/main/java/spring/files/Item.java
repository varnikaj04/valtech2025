package spring.files;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	@SequenceGenerator(name = "itemseq", sequenceName = "item_seq", allocationSize = 1)
	private int id;
	private String name;
	private String description;
	private int currentQuan;
	private int reorderQuan;
	private int maxQuan;
	
	public Item() {}

	public Item(String name, String description, int currentQuan, int reorderQuan, int maxQuan) {
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Item [Id=" + id + ", name=" + name + ", description=" + description + ", currentQuan=" + currentQuan
				+ ", reorderQuan=" + reorderQuan + ", maxQuan=" + maxQuan + "]";
	}
	

}
