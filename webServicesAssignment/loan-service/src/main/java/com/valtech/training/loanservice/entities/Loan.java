package com.valtech.training.loanservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Loan {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq", allocationSize = 1)
	private int id;
	private String userName;
	private int aadhar;
	private int cibilScore;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	private String asset;
	private int assetValue;
	private int value;
	private int income;
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	
	public enum LoanType{
		CAR, HOME, PERSONAL;
	}
	
	public enum LoanStatus{
		APPLIED, APPROVED, PARTIAL_APPROVED, REJECTED
	}
	
	public Loan() {}

	public Loan(String userName, int aadhar, int cibilScore, LoanType loanType, String asset, int assetValue,
			int value, int income, LoanStatus status) {
		this.userName = userName;
		this.aadhar = aadhar;
		this.cibilScore = cibilScore;
		this.loanType = loanType;
		this.asset = asset;
		this.assetValue = assetValue;
		this.value = value;
		this.income = income;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public int getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(int assetValue) {
		this.assetValue = assetValue;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	
	
	
	
}
