package com.simplepayment.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplepayment.entities.Transfer;
import com.simplepayment.projections.TransferMinProjection;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    @Query(nativeQuery = true, value = """
                SELECT u1.use_first_name AS senderFirstName, u1.use_last_name as senderLastName, t.tra_amount AS amount, u2.use_first_name AS receiverFirstName, u2.use_last_name AS receiverLastName FROM transfers t INNER JOIN users u1 ON t.tra_sender_id = u1.use_id INNER JOIN users u2 ON t.tra_receiver_id = u2.use_id WHERE t.tra_id = :id
            """)
    Optional<TransferMinProjection> getMinTransferInfo(Long id);

    @Query(nativeQuery = true, value = """
                SELECT u1.use_first_name AS senderFirstName, u1.use_last_name as senderLastName, t.tra_amount AS amount, u2.use_first_name AS receiverFirstName, u2.use_last_name AS receiverLastName FROM transfers t INNER JOIN users u1 ON t.tra_sender_id = u1.use_id INNER JOIN users u2 ON t.tra_receiver_id = u2.use_id WHERE u1.use_id = :id
            """)
    Optional<Page<TransferMinProjection>> findAllTransferFromUser(Long id, PageRequest setting);
}
