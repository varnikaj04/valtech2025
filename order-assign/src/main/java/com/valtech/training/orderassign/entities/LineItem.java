package com.valtech.training.orderassign.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	@SequenceGenerator(name = "idseq", sequenceName = "id_seq", allocationSize = 1)
	private int lid;
	private int quantity;
	
	@ManyToOne(targetEntity = Item.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Item item;
	
	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "oid")
	private Order order;
	
	
	public LineItem() {}

	public LineItem(int quantity) {
		this.quantity = quantity;
	}
	
	public LineItem(int lid, int quantity) {
		this.lid = lid;
		this.quantity = quantity;
	}

	public LineItem(int lid, int quantity, Item item, Order order) {
		this.lid = lid;
		this.quantity = quantity;
		this.item = item;
		this.order = order;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	
	
}
