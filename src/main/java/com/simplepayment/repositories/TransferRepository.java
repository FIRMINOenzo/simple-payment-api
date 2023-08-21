package com.simplepayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplepayment.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
