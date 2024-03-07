package com.app.banking.model;


import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String password;
	
	@Column(unique=true)
	private String email;
	private String address;
	private String mobileNumber;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	AccountBean accountbean;

	public User() {}
	
	public User(Long id, String name, String password, String email, String address, String mobileNumber,
			AccountBean accountbean) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.accountbean = accountbean;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AccountBean getAccountbean() {
		return accountbean;
	}

	public void setAccountbean(AccountBean accountbean) {
		this.accountbean = accountbean;
	}
	
	
}
