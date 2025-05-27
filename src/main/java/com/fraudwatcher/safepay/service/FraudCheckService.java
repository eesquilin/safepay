package com.fraudwatcher.safepay.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraudwatcher.safepay.model.FraudCheckResult;
import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.repository.FraudCheckResultRepository;
import com.fraudwatcher.safepay.repository.TransactionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FraudCheckService {
    

    @Autowired
    FraudCheckResultRepository fraudCheckRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public FraudCheckResult evaluateTransaction(Long transactionId){
        Transaction transactionToEval = transactionRepository.findById(transactionId)
        .orElseThrow(() -> new EntityNotFoundException("Transaction with ID: " + transactionId + " not found."));

        if (transactionToEval.getAmount().compareTo(BigDecimal.valueOf(5000.00)) > 0) {
            
        }
    }
}
