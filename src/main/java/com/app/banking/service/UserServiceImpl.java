package com.app.banking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.banking.dao.UserRepository;
import com.app.banking.model.AccountBean;
import com.app.banking.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountService accountService;
	
	private final PasswordEncoder passEncode = null;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	 

	@Override
	public User registerUser(User user) {

		String encodedPassword = passEncode.encode(user.getPassword());
		user.setPassword(encodedPassword);

		// Save the user details
		User savedUser = userRepository.save(user);

		// Create an account for the user
		AccountBean account = accountService.createAccount(savedUser);

		savedUser.setAccountbean(account);
		userRepository.save(savedUser);

		logger.info("Account Number: " + savedUser.getAccountbean().getAccountNumber());
		System.out.println(account.getUser().getName());

		return savedUser;
	}
	
	@Override
	  public User getUserByAccountNumber(String accountNumber) {
		  return userRepository.findByAccountAccountNumber(accountNumber); 
		  
	  }

	/*
	 * @Override public void saveUser(User user) { userRepository.save(user);
	 * 
	 * }
	 */
}
