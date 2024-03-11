package com.app.banking.service;


//import org.springframework.http.ResponseEntity;

import com.app.banking.model.AccountBean;
import com.app.banking.model.User;

public interface AccountService {
	
	public AccountBean createAccount(User user);
	public void cashDeposit(String accountNumber,double amount);
	public void cashWithdrawal(String accountNumber,double amount);
	public void fundTransfer(String sourceAccountNumber, String targetAccountNumber,double amount);
	
	

}
