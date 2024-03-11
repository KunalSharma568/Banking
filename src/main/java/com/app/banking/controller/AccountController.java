package com.app.banking.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.banking.model.AccountBean;
import com.app.banking.model.User;
import com.app.banking.service.AccountService;
import com.app.banking.util.AmountRequest;
import com.app.banking.util.FundTransferRequest;
import com.app.banking.util.LoggedInUserDetails;

@RestController
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/accountCreation", method=RequestMethod.POST)
	public AccountBean createAccount(@RequestBody User user){
		logger.info("Enter in Account Creation Controller*********");
		AccountBean accountDetail=new AccountBean();
		accountDetail=accountService.createAccount(user);
		return accountDetail;
	}
	
	@RequestMapping(value="/deposit", method = RequestMethod.POST)
	public ResponseEntity<?> cashDeposit(@RequestBody AmountRequest cashDepositRequest){
		logger.info("Enter in CashDeposit Controller*********");
		if (cashDepositRequest.getAmount() <= 0) {
			Map<String, String> error = new HashMap<>();
			error.put("Error", "Invalid amount");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

		accountService.cashDeposit(LoggedInUserDetails.getAccountNumber(), cashDepositRequest.getAmount());

		Map<String, String> response = new HashMap<>();
		response.put("msg", "Cash deposited successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/withdraw", method = RequestMethod.POST)
	public ResponseEntity<?> cashWithdrawal(@RequestBody AmountRequest cashWithdrawRequest) {
		logger.info("Enter in cashWithdrawal Controller*********");
		if (cashWithdrawRequest.getAmount() <= 0) {
			Map<String, String> err = new HashMap<>();
			err.put("Error", "Invalid amount");
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
		accountService.cashWithdrawal(LoggedInUserDetails.getAccountNumber(), cashWithdrawRequest.getAmount());

		Map<String, String> response = new HashMap<>();
		response.put("msg", "Cash withdrawn successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/fundTransfer", method = RequestMethod.POST)
	public ResponseEntity<?> fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
		if (fundTransferRequest.getAmount() <= 0) {
			Map<String, String> err = new HashMap<>();
			err.put("Error", "Invalid amount");
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}

		accountService.fundTransfer(LoggedInUserDetails.getAccountNumber(), fundTransferRequest.getTargetAccountNumber(),
				fundTransferRequest.getAmount());
		Map<String, String> response = new HashMap<>();
		response.put("msg", "Fund transferred successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
