package com.app.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.banking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
