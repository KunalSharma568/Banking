package com.app.banking.exception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1715504247505190793L;
	
	public NotFoundException(String message) {
		super(message);
	}

}
