package com.fraudwatcher.safepay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/transactions/")
public class TransactionController {
    

    @Autowired
    TransactionService transactionService;

    @GetMapping //Tested
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("user/{userId}") //Tested
    public List<Transaction> getTransactionByUserId(@PathVariable Long userId) {
        return transactionService.getTransactionByUserId(userId);
    }
    
    
    
   
    


}
