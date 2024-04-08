package com.ust.pharma.service;

import com.ust.pharma.exception.PharmaBusinessException;
import com.ust.pharma.model.BatchInfo;


/**
 *Service Interface
 */
public interface IBatch {
    /**
     * @param batchInfo
     * @return boolean
     * @throws PharmaBusinessException
     */
public  abstract  boolean addDetails(BatchInfo batchInfo) throws PharmaBusinessException;

    /**
     * @param batchCode
     * @return boolean
     * @throws PharmaBusinessException
     */
public  abstract  boolean checkBatchCode(String batchCode) throws  PharmaBusinessException;

    /**
     * @param medicineCode
     * @return boolean
     * @throws PharmaBusinessException
     */
public  abstract  boolean checkMedicineCode(String medicineCode) throws PharmaBusinessException;

    /**
     * @param medicineTypeCode
     * @return boolean
     * @throws PharmaBusinessException
     */
public  abstract boolean checkMedicineTypeCode(String medicineTypeCode) throws PharmaBusinessException;

    /**
     * @param medicineTypeCode
     * @param weightRange
     * @return integer
     * @throws PharmaBusinessException
     */
public  abstract  int getShippingCharges(String medicineTypeCode, String weightRange) throws PharmaBusinessException;
}
