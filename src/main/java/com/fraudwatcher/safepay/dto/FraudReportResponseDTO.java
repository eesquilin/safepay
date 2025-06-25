package com.fraudwatcher.safepay.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FraudReportResponseDTO {
    
    private Long Id;
    private Long transactionIdLong;
    private Long userId;
    private LocalDateTime detectedAt;
    private String reason;

}
