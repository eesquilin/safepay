package com.fraudwatcher.safepay.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fraudwatcher.safepay.model.TransactionType;

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
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0.")
    private BigDecimal amount;

    @NotNull(message = "Transaction type is required.")
    private TransactionType type;
    
    @Size(max = 100, message = "Location must be 100 characters.")
    @NotBlank
    private String location;

    @Size(max = 100, message = "Location must be 100 characters.")
    @NotBlank
    private String merchant;

}
