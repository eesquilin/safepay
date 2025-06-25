package com.fraudwatcher.safepay.mapper;

import org.springframework.stereotype.Component;

import com.fraudwatcher.safepay.dto.FraudReportResponseDTO;
import com.fraudwatcher.safepay.model.FraudReport;

@Component
public class FraudReportMapper {

    public FraudReportResponseDTO toResponseDTO(FraudReport report) {
        FraudReportResponseDTO dto = new FraudReportResponseDTO();
        dto.setUserId(report.getUserId());
        dto.setDetectedAt(report.getDetectedAt());
        dto.setTransactionId(report.getTransaction() != null ? report.getTransaction().getId() : null);
        dto.setReason(report.getReason());
        return dto;

    }
}