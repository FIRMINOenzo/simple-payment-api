package com.simplepayment.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplepayment.entities.Transfer;
import com.simplepayment.repositories.TransferRepository;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferRepository transferRepository;

    @GetMapping("/{transferId}")
    public ResponseEntity<Transfer> getTransferById(@PathVariable Long transferId) {
        Optional<Transfer> transfer = transferRepository.findById(transferId);

        if (transfer.isPresent()) {
            return ResponseEntity.ok(transfer.get());
        }

        return ResponseEntity.notFound().build();
    }

}
