package com.simplepayment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplepayment.dtos.TransferReqBodyDTO;
import com.simplepayment.dtos.TransferResBodyDTO;
import com.simplepayment.entities.Transfer;
import com.simplepayment.entities.User;
import com.simplepayment.repositories.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private UserService userService;

    public Transfer findById(Long id) {
        Optional<Transfer> transfer = transferRepository.findById(id);

        if (transfer.isPresent()) {
            return transfer.get();
        }

        return null;
    }

    public TransferResBodyDTO createTransfer(TransferReqBodyDTO newTransfer) {
        TransferResBodyDTO response = new TransferResBodyDTO();

        if (newTransfer.getSender_id() == newTransfer.getReceiver_id()) {
            response.setStatus("error");
            response.setMessage("sender id cannot be the same as the receiver id");

            return response;
        }

        User sender = userService.getUserById(newTransfer.getSender_id());
        User receiver = userService.getUserById(newTransfer.getReceiver_id());

        if (sender == null || receiver == null) {
            response.setStatus("error");
            response.setMessage("invalid accounts");

            return response;
        }

        if (!(sender.getUserType().getDescription().equals("Common"))) {
            response.setStatus("error");
            response.setMessage("invalid user account type");

            return response;
        }

        if (sender.getBalance() < newTransfer.getAmount()) {
            response.setStatus("error");
            response.setMessage("user does not have enough amount");

            return response;
        }

        Transfer transferRecord = new Transfer();

        transferRecord.setSender(sender);
        transferRecord.setReceiver(receiver);
        transferRecord.setAmount(newTransfer.getAmount());

        transferRepository.save(transferRecord);

        response.setStatus("successful");
        response.setMessage("transfer done");

        return response;
    }
}
