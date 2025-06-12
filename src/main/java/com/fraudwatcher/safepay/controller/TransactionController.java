package com.fraudwatcher.safepay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fraudwatcher.safepay.model.FraudCheckResult;
import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.service.FraudCheckService;
import com.fraudwatcher.safepay.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/transactions/")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    FraudCheckService fraudCheckService;

    @PostMapping
    public ResponseEntity<Transaction> postTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("user/{userId}")
    public List<Transaction> getTransactionByUserId(@PathVariable Long userId) {
        return transactionService.getTransactionByUserId(userId);
    }

    @GetMapping("{id}/fraud-check") // Method to check fraud result for an specific transaction.
    public ResponseEntity<FraudCheckResult> getFraudCheckByTransactionId(@PathVariable("id") Long transactionId) {
        FraudCheckResult fResult = fraudCheckService.evaluateTransaction(transactionId);
        return new ResponseEntity<>(fResult, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransactionById(@PathVariable("id") Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found."));
        return Optional.of(transaction);

    }

}
