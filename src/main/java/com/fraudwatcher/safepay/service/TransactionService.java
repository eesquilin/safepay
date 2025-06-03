package com.fraudwatcher.safepay.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.model.TransactionType;
import com.fraudwatcher.safepay.repository.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    //get all transactions of a certain user
    public List<Transaction> getTransactionByUserId(Long userId){
       return transactionRepository.findByUserId(userId);
    }

    //method to create transaction
    public Transaction createTransaction(Transaction transaction){
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    //get transactions by user and transaction type
    public List<Transaction> getByUserIdAndType(Long userId, TransactionType type) {
        return transactionRepository.findByUserIdAndType(userId, type);
    }
}
