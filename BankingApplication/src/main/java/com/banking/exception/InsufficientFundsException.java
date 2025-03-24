package com.banking.exception;

public class InsufficientFundsException extends RuntimeException {
    private static final long serialVersionUID = 1L; // Add this line
    public InsufficientFundsException(String message) {
        super(message);
    }
}
