package com.fraudwatcher.safepay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraudwatcher.safepay.model.FraudCheckResult;
import com.fraudwatcher.safepay.service.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/fraud-checks")
public class FraudCheckController {
    
    private final  FraudCheckService fraudCheckService;

    FraudCheckController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<FraudCheckResult> evaluateTransaction(@PathVariable Long transactionId) {
        FraudCheckResult result = fraudCheckService.evaluateTransaction(transactionId);
        return ResponseEntity.ok(result);
    }
    
    




}
