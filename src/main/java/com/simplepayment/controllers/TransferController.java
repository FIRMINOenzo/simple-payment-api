package com.simplepayment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplepayment.dtos.TransferDTO;
import com.simplepayment.dtos.TransferReqBodyDTO;
import com.simplepayment.dtos.TransferResBodyDTO;
import com.simplepayment.services.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/{transferId}")
    public ResponseEntity<TransferDTO> getTransferById(@PathVariable Long transferId) {
        TransferDTO transfer = transferService.findById(transferId);

        if (transfer != null) {
            return ResponseEntity.ok(transfer);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransferResBodyDTO> createTransfer(@RequestBody TransferReqBodyDTO transferReq) {
        TransferResBodyDTO response = transferService.createTransfer(transferReq);

        if (response.getStatus().equals("error")) {
            return new ResponseEntity<TransferResBodyDTO>(response, null, 403);
        }

        return new ResponseEntity<TransferResBodyDTO>(response, null, 201);
    }
}
