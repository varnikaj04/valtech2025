package com.valtech.training.orderassign.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name = "order_info")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordseq")
	@SequenceGenerator(name = "ordseq", sequenceName = "ord_seq", allocationSize = 1)
	private int oid;
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id", referencedColumnName = "cid")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		PACKED, ONTHEWAY, DELIVERED, RETURNED;
	}
	
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.PERSIST, mappedBy = "order", fetch = FetchType.LAZY)
	private List<LineItem> lineItem;

	public Order() {}

	public Order(int oid, Status status) {
		this.oid = oid;
		this.status = status;
	}

	public Order(int oid, Customer customer, Status status, List<LineItem> lineItem) {
		this.oid = oid;
		this.customer = customer;
		this.status = status;
		this.lineItem = lineItem;
	}
	
	public Order(int oid, Customer customer, List<LineItem> lineItem) {
		this.oid = oid;
		this.customer = customer;
		this.lineItem = lineItem;
	}
	
	
	public void addLineItem(LineItem li) {
		if(lineItem == null) lineItem = new ArrayList<LineItem>();
		lineItem.add(li);
		li.setOrder(this);
	}
	
	public void removeLineItem(LineItem li) {
		lineItem.remove(li);
		li.setOrder(null);
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
	
	public List<LineItem> getLineItem() {
		return lineItem;
	}
	
	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
