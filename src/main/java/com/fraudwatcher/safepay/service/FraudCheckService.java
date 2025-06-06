package com.fraudwatcher.safepay.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    FraudReportService fraudReportService;

    public FraudCheckResult evaluateTransaction(Long transactionId) {

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Transaction with ID: " + transactionId + " not found."));

        List<String> reasonList = new ArrayList<>();

        // Add rules below this line

        if (transaction.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            reasonList.add("High value transaction.");
        }

        // Add rules above this line

        FraudCheckResult result = new FraudCheckResult();

        result.setTransaction(transaction);
        result.setCheckedAt(LocalDateTime.now());
        result.setReasons(reasonList);
        result.setFraud(!reasonList.isEmpty());

        fraudCheckRepository.save(result);

        return result;

    }

}
