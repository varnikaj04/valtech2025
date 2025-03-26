package com.valtech.training.orderassign.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;



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
	
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.MERGE, mappedBy = "item", fetch = FetchType.LAZY)
	private Set<LineItem> lineItem;
	
	public Item() {}

	public Item(int id,String name, String description, int currentQuan, int reorderQuan, int maxQuan) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.currentQuan = currentQuan;
		this.reorderQuan = reorderQuan;
		this.maxQuan = maxQuan;
	}
	
	public Set<LineItem> getLineItem() {
		return lineItem;
	}
	
	public void setLineItem(Set<LineItem> lineItem) {
		this.lineItem = lineItem;
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
