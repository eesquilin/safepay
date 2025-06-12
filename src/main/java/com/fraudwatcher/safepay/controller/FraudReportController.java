package com.fraudwatcher.safepay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraudwatcher.safepay.service.FraudReportService;


@RestController
@RequestMapping("/fraud-reports")
public class FraudReportController {

    final FraudReportService fraudReportService;
    

    FraudReportController(FraudReportService fraudReportService) {
        this.fraudReportService = fraudReportService;
    }

    
   


    
}
