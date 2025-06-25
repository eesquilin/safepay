package com.fraudwatcher.safepay.mapper;

import org.springframework.stereotype.Component;

import com.fraudwatcher.safepay.dto.FraudReportRequestDTO;
import com.fraudwatcher.safepay.dto.FraudReportResponseDTO;
import com.fraudwatcher.safepay.model.FraudReport;

@Component
public class FraudReporMapper {
    
    public FraudReport toEntityFraudReport(FraudReportRequestDTO dto){
        FraudReport report = new FraudReport();
        // TODO map dto to entity
        return report;
    }

    public FraudReportResponseDTO toResponseDTO(FraudReport report){
        FraudReportResponseDTO dto = new FraudReportResponseDTO();
        // TODO create object and map to dto from entity report
        return dto;
    }
}
