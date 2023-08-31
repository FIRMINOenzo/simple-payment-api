package com.simplepayment.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplepayment.dtos.UserDTO;
import com.simplepayment.entities.User;
import com.simplepayment.projections.UserProjection;
import com.simplepayment.repositories.UserRepository;

@Service
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

    public UserDTO getUserInfoById(Long id) {
        Optional<UserProjection> user = userRepository.getUserInfoById(id);

        if (user.isPresent()) {

            UserDTO response = new UserDTO(user.get());

            System.out.println(response.getFirstName());
            System.out.println(response.getLastName());

            return response;
        }

        return null;
    }
}
