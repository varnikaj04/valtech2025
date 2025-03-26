package com.valtech.training.orderassign.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq2")
	@SequenceGenerator(name = "cusseq2", sequenceName = "cus_seq1", allocationSize = 1)
	private int cid;
	private String cname;
	private int age;
	private String address;
	private String permaddress;
	
	public enum CustomerStatus{
		ENABLE, DISABLE
	}
	
	@Enumerated(EnumType.STRING)
	private CustomerStatus cusStatus = CustomerStatus.ENABLE;

	@OneToMany(targetEntity = Order.class, mappedBy = "customer", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<Order> orders;

	public Customer() {}

	public Customer(int cid, String cname, int age, String address, String permaddress, CustomerStatus cusStatus) {
		this.cid = cid;
		this.cname = cname;
		this.age = age;
		this.address = address;
		this.permaddress = permaddress;
		this.cusStatus = cusStatus;
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
	
	public CustomerStatus getCusStatus() {
		return cusStatus;
	}
	
	public void setCusStatus(CustomerStatus cusStatus) {
		this.cusStatus = cusStatus;
	}

}
