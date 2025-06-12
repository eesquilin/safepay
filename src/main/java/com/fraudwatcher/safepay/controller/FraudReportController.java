package com.fraudwatcher.safepay.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fraudwatcher.safepay.model.FraudReport;
import com.fraudwatcher.safepay.service.FraudReportService;

@RestController
@RequestMapping("api/fraud-reports")
public class FraudReportController {

    final FraudReportService fraudReportService;

    FraudReportController(FraudReportService fraudReportService) {
        this.fraudReportService = fraudReportService;
    }

    @PostMapping // Method to create a report manually.
    public ResponseEntity<FraudReport> createReport(@RequestParam Long transactionId, @RequestParam String reason) {
        FraudReport report = fraudReportService.createFraudReport(transactionId, reason);
        return new ResponseEntity<>(report, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudReport> getReportById(@PathVariable("id") Long id) {
        FraudReport fraudReport = fraudReportService.findFraudReportById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found."));
        return ResponseEntity.ok(fraudReport);
    }

    @GetMapping
    public List<FraudReport> getAllReports(){
        return fraudReportService.findAllReports();
    }

}
