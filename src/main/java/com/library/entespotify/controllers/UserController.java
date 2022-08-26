package com.library.entespotify.controllers;

import com.library.entespotify.services.CustomUserService;
import com.library.entespotify.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class UserController {
    @Autowired
    private final CustomUserService userService;

    public UserController(CustomUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerPost(@Valid @RequestBody User user) {
        return ResponseEntity.ok( userService.register(user));
    }
}
