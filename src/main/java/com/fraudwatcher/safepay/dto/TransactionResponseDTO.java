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
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private TransactionType type;
    private String location;
    private String merchant;

}
