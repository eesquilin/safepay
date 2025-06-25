package com.fraudwatcher.safepay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fraudwatcher.safepay.dto.FraudReportResponseDTO;
import com.fraudwatcher.safepay.mapper.FraudReportMapper;
import com.fraudwatcher.safepay.model.FraudReport;
import com.fraudwatcher.safepay.service.FraudReportService;

@RestController
@RequestMapping("api/fraud-reports")
public class FraudReportController {

    final FraudReportService fraudReportService;
    final FraudReportMapper fraudReportMapper;

    FraudReportController(FraudReportService fraudReportService, FraudReportMapper fraudReportMapper) {
        this.fraudReportService = fraudReportService;
        this.fraudReportMapper = fraudReportMapper;
    }

    @PostMapping // Method to create a report manually.
    public ResponseEntity<FraudReportResponseDTO> createReport(@Valid @RequestParam Long transactionId,
            @RequestParam String reason) {
        FraudReport report = fraudReportService.createFraudReport(transactionId, reason);
        FraudReportResponseDTO response = fraudReportMapper.toResponseDTO(report);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudReportResponseDTO> getReportById(@PathVariable("id") Long id) {
        FraudReport fraudReport = fraudReportService.findFraudReportById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found."));
        FraudReportResponseDTO response = fraudReportMapper.toResponseDTO(fraudReport);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<FraudReportResponseDTO> getAllReports() {
        return fraudReportService.findAllReports().stream().map(fraudReportMapper::toResponseDTO).toList();
    }

}
