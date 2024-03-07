package com.app.banking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.banking.model.User;
import com.app.banking.service.UserService;
import com.app.banking.util.UserResponse;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody User user) {
        logger.info("Enter in registerUser()********");
		User registeredUser = userService.registerUser(user);
        
        UserResponse userResponse = new UserResponse();
        userResponse.setName(registeredUser.getName());
        userResponse.setEmail(registeredUser.getEmail());
        userResponse.setAcctNumber(registeredUser.getAccountbean().getAccountNumber());
        userResponse.setIfscCode(registeredUser.getAccountbean().getIfscCode());
        userResponse.setBranch(registeredUser.getAccountbean().getBranch());
        userResponse.setAccounType(registeredUser.getAccountbean().getAccountType());
        

        return ResponseEntity.ok(userResponse);
    }

}
