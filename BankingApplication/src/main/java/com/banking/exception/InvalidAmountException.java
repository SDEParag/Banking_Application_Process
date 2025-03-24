package com.banking.exception;

public class InvalidAmountException extends RuntimeException {
	private static final long serialVersionUID = 1L; // Add this line
    public InvalidAmountException(String message) {
        super(message);
    }
}
