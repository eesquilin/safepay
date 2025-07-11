package com.fraudwatcher.safepay.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fraudwatcher.safepay.model.FraudCheckResult;
import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.model.TransactionType;
import com.fraudwatcher.safepay.repository.TransactionRepository;

@Service
public class TransactionService {

    final TransactionRepository transactionRepository;

    final FraudCheckService fraudCheckService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    TransactionService(TransactionRepository transactionRepository, FraudCheckService fraudCheckService) {
        this.transactionRepository = transactionRepository;
        this.fraudCheckService = fraudCheckService;
    }

    public List<Transaction> getAllTransactions() {
        logger.debug("Fetching all transactions...");
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long transactionId) {
        logger.debug("Fetching transaction {}.", transactionId);
        return transactionRepository.findById(transactionId);
    }

    // get all transactions of a certain user
    public Page<Transaction> getTransactionByUserId(Long userId, Pageable pageable) {
        return transactionRepository.findByUserId(userId, pageable);
        
    }

    // method to create transaction and detect possible fraud during transaction
    // creation
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);
        logger.info("Transaction posted for userId: {}", transaction.getUserId());

        FraudCheckResult result = fraudCheckService.evaluateTransaction(savedTransaction.getId());

        if (result.isFraud()) {
            // System.out.printf("Potential fraud detected for transaction %d.%n", savedTransaction.getId());
            logger.warn("Potential fraud detected for transaction {}.", savedTransaction.getId());
        }

        return savedTransaction;

    }

    // get transactions by user and transaction type
    public Page<Transaction> getByUserIdAndType(Long userId, TransactionType type, Pageable pageable) {
        return transactionRepository.findByUserIdAndType(userId, type, pageable);
    }

}
