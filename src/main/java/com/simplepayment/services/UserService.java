package com.simplepayment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.simplepayment.entities.User;
import com.simplepayment.repositories.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }
}
