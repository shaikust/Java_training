package com.ust.pharma.repository;

import com.ust.pharma.model.BatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *BatchInfo Repository
 */
@Repository
public interface BatchInfoRepository extends JpaRepository<BatchInfo,String> {
    boolean existsByBatchCode(String batchCode);
}
