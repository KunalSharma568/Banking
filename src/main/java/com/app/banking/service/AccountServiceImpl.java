package com.app.banking.service;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.banking.dao.AccountRepository;
import com.app.banking.dao.TransactionRepository;
import com.app.banking.exception.NotFoundException;
import com.app.banking.model.AccountBean;
import com.app.banking.model.Transaction;
import com.app.banking.model.User;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
    public AccountBean createAccount(User user) {
		logger.info("Enter in accountService-> CreateAccount********");
        String accountNumber = generateUniqueAccountNumber();
        AccountBean account = new AccountBean();
        account.setAccountNumber(accountNumber);
        account.setCurrentBalance(0.0);
        return accountRepository.save(account);
    }
	
	
	private String generateUniqueAccountNumber() {
		logger.info("Enter in accountService-> generateUniqueAccountNumber********");
	    String accountNumber;
	    do {
	        // Generate a UUID as the account number
	        accountNumber = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
	    } while (accountRepository.findByAccountNumber(accountNumber) != null);

	    return accountNumber;
	}
	
	@Override
    public void cashDeposit(String accountNumber,double amount) {
        AccountBean account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new NotFoundException("Account not found");
        }
        double totalBalance = account.getCurrentBalance();
        double newBalance = totalBalance  + amount;
        account.setCurrentBalance(newBalance);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType("CASH_DEPOSIT");
        transaction.setTransactionDate(new Date());
        transactionRepository.save(transaction);
    }

}
