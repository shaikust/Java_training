package com.ust.pharma.service;

import com.ust.pharma.exception.PharmaBusinessException;
import com.ust.pharma.model.BatchInfo;
import com.ust.pharma.model.ShippingMaster;
import com.ust.pharma.repository.BatchInfoRepository;
import com.ust.pharma.repository.MedicineMasterRepository;
import com.ust.pharma.repository.MedicineTypeMasterRepository;
import com.ust.pharma.repository.ShippingMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *BatchImplementation class
 */
@Service
public class BatchImpl implements IBatch{
    private final BatchInfoRepository batchRepository;
    private  final MedicineMasterRepository medicineMasterRepository;
    private  final MedicineTypeMasterRepository medicineTypeMasterRepository;
    private  final ShippingMasterRepository shippingMasterRepository;
    @Autowired
    public BatchImpl(BatchInfoRepository batchRepository, MedicineMasterRepository medicineMasterRepository, MedicineTypeMasterRepository medicineTypeMasterRepository, ShippingMasterRepository shippingMasterRepository) {
        this.batchRepository = batchRepository;
        this.medicineMasterRepository = medicineMasterRepository;
        this.medicineTypeMasterRepository = medicineTypeMasterRepository;
        this.shippingMasterRepository = shippingMasterRepository;
    }


    /**
     * @param batchInfo
     * @return boolean
     * @throws PharmaBusinessException
     */
    @Override
    public boolean addDetails(BatchInfo batchInfo) throws PharmaBusinessException {
        try {
            // Check if the batch code already exists
            if (checkBatchCode(batchInfo.getBatchCode())) {
                throw new PharmaBusinessException("Batch code already exists.");
            }
            // Check if the medicine code exists
            if (!checkMedicineCode(batchInfo.getMedicineCode())) {
                throw new PharmaBusinessException("Medicine code does not exist.");
            }
            if(!checkMedicineTypeCode(batchInfo.getMedicineTypeCode())){
                throw  new PharmaBusinessException("Medicine type code doesn't exist");
            }
            // Validate minimum batch weight
            if (batchInfo.getWeight() < 100) {
                throw new PharmaBusinessException("Each batch should weigh a minimum of 100 quintals.");
            }
            // Calculate shipping charge
            int shippingCharge = getShippingCharges(batchInfo.getMedicineTypeCode(), calculateWeightRange(batchInfo.getWeight()));
            // Apply refrigeration charge if necessary
            if (batchInfo.isRefrigeration()) {
                shippingCharge += (shippingCharge * 0.05); // 5% additional charge for refrigeration
            }
            batchInfo.setShippingCharge((double) shippingCharge);
            // Set care level based on medicine type
            if ("Capsule".equals(batchInfo.getMedicineTypeCode())) {
                batchInfo.setCareLevel("Normal");
            } else if ("Syrups".equals(batchInfo.getMedicineTypeCode())) {
                batchInfo.setCareLevel("Extremely High");
            }
            // Simulate saving to the system
            // Assuming saving to repository or database here
            batchRepository.save(batchInfo);
            return true;
        }catch (Exception ex) {
            // Catch any exceptions and rethrow as PharmaBusinessException
            throw new PharmaBusinessException("Error adding batch details: " + ex.getMessage());
        }
    }

    /**
     * @param batchCode
     * @return boolean
     * @throws PharmaBusinessException
     */
    @Override
    public boolean checkBatchCode(String batchCode) throws PharmaBusinessException {
        return batchRepository.existsByBatchCode(batchCode);
    }

    /**
     * @param medicineCode
     * @return boolean
     * @throws PharmaBusinessException
     */
    @Override
    public boolean checkMedicineCode(String medicineCode) throws PharmaBusinessException {
        return  medicineMasterRepository.existsByMedicineCode(medicineCode);
    }

    /**
     * @param medicineTypeCode
     * @return boolean
     * @throws PharmaBusinessException
     */
    @Override
    public boolean checkMedicineTypeCode(String medicineTypeCode) throws PharmaBusinessException {
        return medicineTypeMasterRepository.existsByMedicineTypeCode(medicineTypeCode);
    }

    /**
     * @param medicineTypeCode
     * @param weightRange
     * @return integer
     * @throws PharmaBusinessException
     */
    @Override
    public int getShippingCharges(String medicineTypeCode, String weightRange) throws PharmaBusinessException {
        try {
            // Fetch shipping charge from SHIPPING_MASTER table based on medicine type code and weight range
            ShippingMaster shippingMaster = shippingMasterRepository.findByMedicineTypeCodeAndWeightRange(medicineTypeCode, weightRange);

            // If shipping charge is found, return it
            if (shippingMaster != null) {
                return shippingMaster.getShippingCharge().intValue();
            } else {
                throw new PharmaBusinessException("Shipping charge not found for medicine type code " + medicineTypeCode + " and weight range " + weightRange);
            }
        } catch (Exception ex) {
            // Catch any exceptions and rethrow as PharmaBusinessException
            throw new PharmaBusinessException("Error fetching shipping charge: " + ex.getMessage());
        }
    }
    // Helper method to calculate weight range based on batch weight
    private String calculateWeightRange(Double weight) {
        if (weight <= 500) {
            return "W1";
        } else if (weight <= 1000) {
            return "W2";
        } else {
            return "W3";
        }
    }
}
