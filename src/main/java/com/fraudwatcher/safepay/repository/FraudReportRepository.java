package com.fraudwatcher.safepay.repository;

import com.fraudwatcher.safepay.model.FraudReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudReportRepository extends JpaRepository<FraudReport, Long> {


}
