package com.banking.service;

import com.banking.dto.TransactionRequest;
import com.banking.entity.Account;

public interface BankService {
    double getBalance();
    void deposit(TransactionRequest request);
    void withdraw(TransactionRequest request);
}
