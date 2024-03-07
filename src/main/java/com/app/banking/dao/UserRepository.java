package com.app.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.banking.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByAccountAccountNumber(String accountNumber);
}
