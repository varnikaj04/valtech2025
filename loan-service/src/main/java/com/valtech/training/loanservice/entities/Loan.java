package com.valtech.training.loanservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Loan {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq", allocationSize = 1)
	private long id;
	private int value;
	private LoanType type;
	private int assetValue;
	private LoanStatus status;
	
	enum LoanType{
		CAR, HOME, PERSONAL;
	}
	
	enum LoanStatus{
		APPLIED, APPROVED, PARTIAL_APPROVED, REJECTED
	}
	
	public Loan() {}

	public Loan(long id, int value, LoanType type, int assetValue, LoanStatus status) {
		this.id = id;
		this.value = value;
		this.type = type;
		this.assetValue = assetValue;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LoanType getType() {
		return type;
	}

	public void setType(LoanType type) {
		this.type = type;
	}

	public int getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(int assetValue) {
		this.assetValue = assetValue;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}
	
	
	
	
}
