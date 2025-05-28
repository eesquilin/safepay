package com.fraudwatcher.safepay.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraudwatcher.safepay.model.FraudCheckResult;
import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.model.TransactionType;
import com.fraudwatcher.safepay.repository.FraudCheckResultRepository;
import com.fraudwatcher.safepay.repository.TransactionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FraudCheckService {

    @Autowired
    FraudCheckResultRepository fraudCheckRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public FraudCheckResult evaluateTransaction(Long transactionId) {

        List<String> reasonList = new ArrayList<>();

        Transaction currentTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Transaction with ID: " + transactionId + " not found."));

        //Rule $5000 withdrawal limit                
        if (currentTransaction.getType() == TransactionType.WITHDRAWAL
                && currentTransaction.getAmount().compareTo(BigDecimal.valueOf(5000)) > 0) {
            reasonList.add("Transaction amount exceeds limit.");
        }

        // Add rules below this line

        boolean isFraud = !reasonList.isEmpty();

        FraudCheckResult result = new FraudCheckResult(
                null,
                currentTransaction,
                isFraud,
                String.join("; ",
                        reasonList),
                LocalDateTime.now()

        );

        fraudCheckRepository.save(result);

        return result;

    }
}
