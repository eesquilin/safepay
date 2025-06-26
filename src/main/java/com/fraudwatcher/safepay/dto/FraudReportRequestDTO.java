package com.fraudwatcher.safepay.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FraudReportRequestDTO {

    @NotNull(message = "Transaction Id required.")
    private Long transactionId;

    @NotNull
    @NotBlank
    private String reason;
}
