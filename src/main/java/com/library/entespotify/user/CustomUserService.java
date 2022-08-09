package com.library.entespotify.user;

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

    public boolean isLoggedIn() {
        return true;
    }

    public User register(User newUser) {
        newUser.setPassword(passwordEncoder.encode( newUser.getPassword()));
        return userRepository.save(newUser);
    }
}
