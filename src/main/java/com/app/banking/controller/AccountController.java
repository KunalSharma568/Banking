package com.app.banking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.banking.model.AccountBean;
import com.app.banking.model.User;
import com.app.banking.service.AccountService;
import com.app.banking.util.CashDepositRequest;
import com.app.banking.util.LoggedInUserDetails;

@RestController
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountService accountServce;
	
	@RequestMapping(value="/accountCreation", method=RequestMethod.POST)
	public AccountBean createAccount(@RequestBody User user){
		logger.info("Enter in Account Creation Controller*********");
		AccountBean accountDetail=new AccountBean();
		accountDetail=accountServce.createAccount(user);
		return accountDetail;
	}
	
	@RequestMapping(value="/deposit", method = RequestMethod.POST)
	public ResponseEntity<?> cashDeposit(@RequestBody CashDepositRequest cashDepositRequest){
		logger.info("Enter in CashDeposit Controller*********");
		if (cashDepositRequest.getAmount() <= 0) {
			Map<String, String> error = new HashMap<>();
			error.put("Error", "Invalid amount");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

		accountServce.cashDeposit(LoggedInUserDetails.getAccountNumber(), cashDepositRequest.getAmount());

		Map<String, String> response = new HashMap<>();
		response.put("msg", "Cash deposited successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
