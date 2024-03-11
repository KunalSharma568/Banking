package com.app.banking.exception;

public class InsufficientBalanceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4248653565427739198L;

	public InsufficientBalanceException(String message) {
		super(message);
	}
	
}
