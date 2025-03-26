package com.valtech.training.registerservice.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	private long id;
	private String name;
	private String mobileNo;
	private int age;
	private String email;
	private Boolean kid;

	@ManyToOne(targetEntity = Subscription.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "subs_id", referencedColumnName = "id")
	private Subscription subscription;

	public User() {}

	public User(long id, String name, String mobileNo, int age, String email, Boolean kid) {
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.age = age;
		this.email = email;
		this.kid = kid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getKid() {
		return kid;
	}
	
	public void setKid(Boolean kid) {
		this.kid = kid;
	}
	
	public Subscription getSubscription() {
		return subscription;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	
}
