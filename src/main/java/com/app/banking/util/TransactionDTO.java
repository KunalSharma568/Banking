package com.app.banking.util;

import java.util.Date;

public class TransactionDTO {
	
	 private Long id; 
	    private double amount;
	    private String transactionType;
	    private Date transactionDate;
	    private String sourceAccountNumber;
	    private String targetAccountNumber;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
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
			return transactionDate;
		}
		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}
		public String getSourceAccountNumber() {
			return sourceAccountNumber;
		}
		public void setSourceAccountNumber(String sourceAccountNumber) {
			this.sourceAccountNumber = sourceAccountNumber;
		}
		public String getTargetAccountNumber() {
			return targetAccountNumber;
		}
		public void setTargetAccountNumber(String targetAccountNumber) {
			this.targetAccountNumber = targetAccountNumber;
		}

}
