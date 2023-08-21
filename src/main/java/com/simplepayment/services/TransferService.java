package com.simplepayment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.simplepayment.entities.Transfer;
import com.simplepayment.repositories.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public Transfer findById(Long id) {
        Optional<Transfer> transfer = transferRepository.findById(id);

        if (transfer.isPresent()) {
            return transfer.get();
        }

        return null;
    }
}
