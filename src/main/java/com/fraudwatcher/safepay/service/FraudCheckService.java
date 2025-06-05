package com.fraudwatcher.safepay.service;

import java.math.BigDecimal;
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

        List<String> reasonList = new ArrayList<>();

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Transaction with ID: " + transactionId + " not found."));

        //Rule $5000 withdrawal limit                
//        if (currentTransaction.getType() == TransactionType.WITHDRAWAL
//                && currentTransaction.getAmount().compareTo(BigDecimal.valueOf(5000)) > 0) {
//            reasonList.add("Transaction amount exceeds limit.");
//        }

        // Add rules below this line

//        boolean isFraud = !reasonList.isEmpty();

        FraudCheckResult result = runRules(transaction);



        fraudCheckRepository.save(result);

        return result;

    }

    private FraudCheckResult runRules(Transaction transaction) {
        //Rules below this line.
        if (transaction.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0){
            return new FraudCheckResult(true,"High Value Transaction");
        }

        //Add rules above this line.
        else return new FraudCheckResult(false, "No signs of fraud.");
    }
}
