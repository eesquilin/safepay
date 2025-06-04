package com.fraudwatcher.safepay.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FraudReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    Long transactionId;


    Long userId;

    LocalDateTime detectedAt; // TODO if detection is implemented at creation can be linked with it

    String reason;
}
