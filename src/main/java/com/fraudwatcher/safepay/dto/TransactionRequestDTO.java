package com.fraudwatcher.safepay.dto;

import java.math.BigDecimal;

import com.fraudwatcher.safepay.model.TransactionType;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDTO {

    @NotNull(message = "User Id required.")
    @Min(1)
    private Long userId;

    @NotNull(message = "Amount is required.")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0.") // TODO Need to verify validation of min value
    private BigDecimal amount;

    @NotNull(message = "Transaction type is required.")
    private TransactionType type;
    
    @Size(max = 100, message = "Location must be 100 characters.")
    @NotBlank
    @NotNull
    private String location;

    @Size(max = 100, message = "Location must be 100 characters.")
    @NotBlank
    @NotNull
    private String merchant;

}
