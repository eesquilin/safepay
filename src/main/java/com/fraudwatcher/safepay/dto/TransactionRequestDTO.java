package com.fraudwatcher.safepay.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fraudwatcher.safepay.model.TransactionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDTO {

    @NotNull(message = "User Id required.")
    Long userId;

    @NotNull(message = "Amount is required.")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0.")
    BigDecimal amount;

    @NotNull(message = "Transaction type is required.")
    TransactionType type;

    String location;
    String merchant;


}
