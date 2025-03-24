package com.banking.service.impl;

import org.springframework.stereotype.Service;
import com.banking.dto.TransactionRequest;
import com.banking.entity.Account;
import com.banking.exception.InsufficientFundsException;
import com.banking.exception.InvalidAmountException;
import com.banking.repository.BankRepository;
import com.banking.service.BankService;
import jakarta.transaction.Transactional;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;

        // Initialize an account with ₹1000 if the database is empty
        if (bankRepository.count() == 0) {
            bankRepository.save(new Account(1000.0));
        }
    }

    @Override
    public double getBalance() {
        Account account = bankRepository.findById(1L).orElseThrow();
        return account.getBalance();
    }

    @Override
    @Transactional
    public void deposit(TransactionRequest request) {
        if (request.getAmount() <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        Account account = bankRepository.findById(1L).orElseThrow();
        account.setBalance(account.getBalance() + request.getAmount());
        bankRepository.save(account);
    }

    @Override
    @Transactional
    public void withdraw(TransactionRequest request) {
        if (request.getAmount() <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        Account account = bankRepository.findById(1L).orElseThrow();
        if (request.getAmount() > account.getBalance()) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        account.setBalance(account.getBalance() - request.getAmount());
        bankRepository.save(account);
    }
}
