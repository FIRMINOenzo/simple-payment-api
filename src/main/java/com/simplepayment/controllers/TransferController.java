package com.simplepayment.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplepayment.dtos.TransferReqBodyDTO;
import com.simplepayment.entities.Transfer;
import com.simplepayment.entities.User;
import com.simplepayment.repositories.UserRepository;
import com.simplepayment.services.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{transferId}")
    public ResponseEntity<Transfer> getTransferById(@PathVariable Long transferId) {
        Transfer transfer = transferService.findById(transferId);

        if (transfer != null) {
            return ResponseEntity.ok(transfer);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createTransfer(@RequestBody TransferReqBodyDTO transferReq) {
        if (transferReq.getSender_id() == transferReq.getReceiver_id()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Optional<User> senderUser = userRepository.findById(transferReq.getSender_id());
        Optional<User> receiverUser = userRepository.findById(transferReq.getReceiver_id());

        if (senderUser.isEmpty() && receiverUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            User user = senderUser.get();

            if (!(user.getUserType().getDescription().equals("Common"))) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
