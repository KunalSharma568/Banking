package com.app.banking.service;

import com.app.banking.model.User;

public interface UserService {
	
	public User registerUser(User user);
	public User getUserByAccountNumber(String accountNumber);

}
