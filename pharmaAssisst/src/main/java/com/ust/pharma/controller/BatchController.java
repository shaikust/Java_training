package com.ust.pharma.controller;

import com.ust.pharma.exception.PharmaBusinessException;
import com.ust.pharma.model.BatchInfo;
import com.ust.pharma.service.BatchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BatchController Class
 */
@RestController
@RequestMapping("/batches")
public class BatchController {
    private final BatchImpl batchService;

    @Autowired
    public BatchController(BatchImpl batchService) {
        this.batchService = batchService;
    }

    /**
     * @param batchInfo
     * @return String
     */
    @PostMapping("/add")
    public ResponseEntity<String> addBatch(@RequestBody BatchInfo batchInfo) {
        try {
            if (batchService.addDetails(batchInfo)) {
                return ResponseEntity.ok("Batch added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add batch.");
            }
        } catch (PharmaBusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
