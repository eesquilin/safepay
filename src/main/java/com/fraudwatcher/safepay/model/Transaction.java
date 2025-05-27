package com.fraudwatcher.safepay.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long userId;
    float amount;
    Date timestamp; // Optimize datetime format
    String location;
    String merchant; // TODO Create an enum to enumerate merchants


}
