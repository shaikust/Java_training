package com.ust.pharma.repository;

import com.ust.pharma.model.ShippingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ShippingMaster Repository
 */
@Repository
public interface ShippingMasterRepository extends JpaRepository<ShippingMaster,Long> {
    ShippingMaster findByMedicineTypeCodeAndWeightRange( String medicineTypeCode, String weightRange);
}
