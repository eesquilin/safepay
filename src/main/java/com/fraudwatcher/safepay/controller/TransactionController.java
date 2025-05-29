package com.fraudwatcher.safepay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/transactions/")
public class TransactionController {
    

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{userId}")
    public List<Transaction> getMethodName(@RequestParam Long userId) {
        return transactionService.getTransactionByUserId(userId);
    }
    
    
   
    


}
