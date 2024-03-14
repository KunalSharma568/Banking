package com.app.banking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.banking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	List<Transaction> findBySourceAcctrOrTargetAcctAcctNumber(String sourceAccountNumber, String targetAccountNumber);
}
