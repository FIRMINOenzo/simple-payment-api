package com.simplepayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplepayment.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
