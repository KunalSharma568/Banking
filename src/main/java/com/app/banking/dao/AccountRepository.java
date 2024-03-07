package com.app.banking.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.banking.model.AccountBean;

@Repository
public interface AccountRepository extends JpaRepository<AccountBean, Long> {
	
	    AccountBean findByAccountNumber(String accountNumber);
}
