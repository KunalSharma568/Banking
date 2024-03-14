package com.app.banking.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user", schema = "ksbank")
public class AccountBean {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String accountNumber;
	private double currentBalance;
	private String accountType;
	private String branch;
	private String ifscCode;
	private String accountStatus;
	
	/*@OneToOne*/
	private User user;
	
	public AccountBean() {	
	}
	
	

	public AccountBean(long id, String accountNumber, double currentBalance, String accountType, String branch,
			String ifscCode, String accountStatus, User user) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.accountType = accountType;
		this.branch = branch;
		this.ifscCode = ifscCode;
		this.accountStatus = accountStatus;
		this.user = user;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", accountNumber=" + accountNumber + ", currentBalance=" + currentBalance
				+ ", accountType=" + accountType + ", branch=" + branch + ", ifscCode=" + ifscCode + ", accountStatus="
				+ accountStatus + ", user=" + user + "]";
	}
	

}
