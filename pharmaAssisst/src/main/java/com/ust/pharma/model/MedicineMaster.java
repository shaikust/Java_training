package com.ust.pharma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for MedicineMaster
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEDICINE_MASTER")
public class MedicineMaster {
    @Id
    @Column(name = "MEDICINE_CODE")
    private String medicineCode;

    @Column(name = "MEDICINE_NAME")
    private String medicineName;

}
