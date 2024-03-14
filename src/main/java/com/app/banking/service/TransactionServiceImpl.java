package com.app.banking.service;

import java.util.List;
import java.util.stream.Collectors;  


import org.springframework.beans.factory.annotation.Autowired;

import com.app.banking.dao.TransactionRepository;
import com.app.banking.mapper.TransactionMapper;
import com.app.banking.model.Transaction;
import com.app.banking.util.TransactionDTO;

public class TransactionServiceImpl implements TransactionService{

	
	@Autowired
	private TransactionRepository transactionRepository;

	 @Autowired
	    private TransactionMapper transactionMapper;

	 @Override
	 public List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber) {
	     List<Transaction> transactions = transactionRepository.findBySourceAcctrOrTargetAcctAcctNumber(accountNumber, accountNumber);
	     
	     List<TransactionDTO> transactionDTOs = transactions.stream()
	             .map(transactionMapper::transctionMapper)
	             .sorted((t1, t2) -> t2.getTransactionDate().compareTo(t1.getTransactionDate()))
	             .collect(Collectors.toList());

	     return transactionDTOs;
	 }

}
