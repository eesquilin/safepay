package com.fraudwatcher.safepay.dto;

import com.fraudwatcher.safepay.model.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponseDTO {
    Long id;
    Long userId;
    BigDecimal amount;
    LocalDateTime timestamp;
    TransactionType type;
    String location;
    String merchant;

}
