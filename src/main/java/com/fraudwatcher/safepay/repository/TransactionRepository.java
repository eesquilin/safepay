package com.fraudwatcher.safepay.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fraudwatcher.safepay.model.Transaction;
import com.fraudwatcher.safepay.model.TransactionType;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByUserId(Long userId, Pageable pageable);

    Page<Transaction> findByUserIdAndTimestampBetween(Long userId, LocalDateTime start, LocalDateTime end,
            Pageable pageable);

    Page<Transaction> findByUserIdAndAmountBetween(Long userId, BigDecimal min, BigDecimal max, Pageable pageable);

    Page<Transaction> findByUserIdAndType(Long userId, TransactionType type, Pageable pageable);

}
