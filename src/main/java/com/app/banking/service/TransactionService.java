package com.app.banking.service;

import java.util.List;

import com.app.banking.util.TransactionDTO;

public interface TransactionService {
	
	List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);

}
