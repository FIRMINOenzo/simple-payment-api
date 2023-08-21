package com.simplepayment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplepayment.entities.Transfer;
import com.simplepayment.services.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/{transferId}")
    public ResponseEntity<Transfer> getTransferById(@PathVariable Long transferId) {
        Transfer transfer = transferService.findById(transferId);

        if (transfer != null) {
            return ResponseEntity.ok(transfer);
        }

        return ResponseEntity.notFound().build();
    }

}
