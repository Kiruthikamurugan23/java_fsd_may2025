package com.backend.fastx.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.fastx.model.User;
import com.backend.fastx.repository.UserRepository;


import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(User user) {
        String plainPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    // Returns User or null if not found
    public User getById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    // You can just call getById internally or keep it for semantics
    public User getUserById(int userId) {
        return getById(userId);
    }

    // Update user entity
    public void updateUser(User user) {
        userRepository.save(user);
    }
}



