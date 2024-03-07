package com.app.banking.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.app.banking.exception.NotFoundException;

public class LoggedInUserDetails {

	private static final Logger logger = LoggerFactory.getLogger(LoggedInUserDetails.class);
	
	
	public static String getAccountNumber() {
		logger.info("Inside getAccountNumber********");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            
            if (principal instanceof User) {
            	 User user = (User) principal;
                 return user.getUsername();
            }
        }
        throw new NotFoundException("Account number not found.");
    }
}
