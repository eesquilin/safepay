package com.fraudwatcher.safepay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fraudwatcher.safepay.model.FraudCheckResult;

@Repository
public interface FraudCheckResultRepository extends JpaRepository<FraudCheckResult, Long>{
    
}
