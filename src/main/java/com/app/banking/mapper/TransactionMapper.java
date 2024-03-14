package com.app.banking.mapper;

import org.springframework.stereotype.Component;

import com.app.banking.model.Transaction;
import com.app.banking.util.TransactionDTO;

@Component
public class TransactionMapper {

	public TransactionDTO transctionMapper(Transaction transaction) {
        TransactionDTO transObj = new TransactionDTO();
        transObj.setId(transaction.getId());
        transObj.setAmount(transaction.getAmount());
        transObj.setTransactionType(transaction.getTransactionType());
        transObj.setTransactionDate(transaction.getTransactionDate());
        transObj.setSourceAccountNumber(transaction.getSourceAccount().getAccountNumber());
        if (transaction.getTargetAccount() != null) {
        	transObj.setTargetAccountNumber(transaction.getTargetAccount().getAccountNumber());
        } else {
        	transObj.setTargetAccountNumber("N/A"); 
        }
        return transObj;
    }
}
