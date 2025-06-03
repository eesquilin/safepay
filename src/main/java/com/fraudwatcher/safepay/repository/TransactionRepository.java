package com.fraudwatcher.safepay.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.model.TransactionType;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByUserIdAndTimestampBetween(Long userId, LocalDateTime start, LocalDateTime end);

    List<Transaction> findByUserIdAndAmountBetween(Long userId, BigDecimal min, BigDecimal max);

    List<Transaction> findByUserIdAndType(Long userId, TransactionType type);
    
}
