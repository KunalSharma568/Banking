package com.app.banking.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double amount;
	private String transactionType;
	private Date TransactionDate;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "")
	 */
	private AccountBean sourceAccount;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "")
	 */
	private AccountBean targetAccount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}

	public AccountBean getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(AccountBean sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public AccountBean getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(AccountBean targetAccount) {
		this.targetAccount = targetAccount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", transactionType=" + transactionType
				+ ", TransactionDate=" + TransactionDate + ", sourceAccount=" + sourceAccount + ", targetAccount="
				+ targetAccount + "]";
	}
	
		
}
