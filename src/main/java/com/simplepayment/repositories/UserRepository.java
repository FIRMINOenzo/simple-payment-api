package com.simplepayment.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplepayment.entities.User;
import com.simplepayment.projections.UserProjection;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = """
                SELECT u.use_id AS userId, u.use_first_name AS userFirstName, u.use_last_name AS userLastName, t.typ_description AS userType FROM users u INNER JOIN user_types t ON u.use_type_id = t.typ_id WHERE u.use_id = :id
            """)
    Optional<UserProjection> getUserInfoById(Long id);
}
