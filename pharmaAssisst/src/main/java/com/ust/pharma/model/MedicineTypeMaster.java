package com.ust.pharma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for MedicineTypeMaster
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEDICINE_TYPE_MASTER")
public class MedicineTypeMaster {
    @Id
    @Column(name = "MEDICINE_TYPE_CODE")
    private String medicineTypeCode;

    @Column(name = "MEDICINE_TYPE_NAME")
    private String medicineTypeName;

}
