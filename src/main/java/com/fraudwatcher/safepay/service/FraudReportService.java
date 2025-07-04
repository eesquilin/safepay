package com.fraudwatcher.safepay.service;

import com.fraudwatcher.safepay.model.FraudReport;
import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.repository.FraudReportRepository;
import com.fraudwatcher.safepay.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudReportService {

    @Autowired
    FraudReportRepository fraudReportRepository;
    private final TransactionRepository transactionRepository;
    

    FraudReportService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public FraudReport createFraudReport(Long transactionId, String reason) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction ID" + transactionId + " not found."));

        FraudReport report = new FraudReport();
        report.setDetectedAt(LocalDateTime.now());
        report.setUserId(transaction.getUserId());
        report.setReason(reason);; // TODO Relate it OneToOne with FraudCheckResult in the model.
        report.setTransaction(transaction);

        return fraudReportRepository.save(report);

    }

    public Optional<FraudReport> findFraudReportById(Long id){
        return fraudReportRepository.findById(id);
    }

    public List<FraudReport> findAllReports(){
        return fraudReportRepository.findAll();
    }
}
