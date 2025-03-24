package com.banking.controller;

import com.banking.dto.TransactionRequest;
import com.banking.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance() {
        return ResponseEntity.ok(bankService.getBalance());
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody TransactionRequest request) {
        bankService.deposit(request);
        return ResponseEntity.ok("Deposit successful! New balance: ₹" + bankService.getBalance());
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody TransactionRequest request) {
        bankService.withdraw(request);
        return ResponseEntity.ok("Withdrawal successful! New balance: ₹" + bankService.getBalance());
    }
}
