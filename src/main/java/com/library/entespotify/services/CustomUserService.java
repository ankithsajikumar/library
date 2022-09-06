package com.library.entespotify.services;

import com.library.entespotify.models.User;
import com.library.entespotify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User newUser) {
        newUser.setPassword(passwordEncoder.encode( newUser.getPassword()));
        return userRepository.save(newUser);
    }
}
