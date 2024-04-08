package com.ust.pharma.repository;

import com.ust.pharma.model.MedicineTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MedicineTypeMaster Repository
 */
@Repository
public interface MedicineTypeMasterRepository extends JpaRepository<MedicineTypeMaster,String> {
    boolean existsByMedicineTypeCode(String medicineTypeCode);
}
