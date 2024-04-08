package com.ust.pharma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *Entity class for Batch_Info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BATCH_INFO")
public class BatchInfo {
    @Id
    @Column(name = "BATCH_CODE")
    private String batchCode;

    @Column(name = "MEDICINE_CODE")
    private String medicineCode;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "PRICE_MED")
    private Double medicinePrice;

    @Column(name = "MEDICINE_TYPE_CODE")
    private String medicineTypeCode;

    @Column(name = "SHIPPING_CHARGE")
    private Double shippingCharge;

    @Column(name = "CARE_LEVEL")
    private String careLevel;

    private  boolean refrigeration;

}
