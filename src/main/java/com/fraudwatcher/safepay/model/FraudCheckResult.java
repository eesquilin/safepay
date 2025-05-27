package com.fraudwatcher.safepay.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class FraudCheckResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "transaction_id", unique = true)
    Transaction transaction;
    
    boolean isFraud;
    
    String reasons; // TODO Create an enum with reasons to standarize logic for denial/acceptance reason. 
    
    LocalDateTime checkedAt;

}
