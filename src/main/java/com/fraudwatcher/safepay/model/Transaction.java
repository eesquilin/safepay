package com.fraudwatcher.safepay.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private Long userId;
    
    @NonNull
    private BigDecimal amount;
    
    private LocalDateTime timestamp;
    
    @Enumerated(EnumType.STRING) 
    private TransactionType type;
    
    private String location; // TODO set automated way to get location
    
    private String merchant; // TODO Create an enum to enumerate merchants


}
