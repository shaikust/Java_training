package com.ust.pharma.repository;

import com.ust.pharma.model.MedicineMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MedicineMaster Repository
 */
@Repository
public interface MedicineMasterRepository extends JpaRepository<MedicineMaster,String> {
    boolean existsByMedicineCode(String medicineCode);
}
