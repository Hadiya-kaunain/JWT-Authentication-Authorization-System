package com.dextero.user_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.dextero.user_management.entity.User;
import com.dextero.user_management.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public User getProfile(Authentication authentication) {
        String email = authentication.getName();
        return userService.getUserById(
                userService.getAllUsers().stream()
                        .filter(u -> u.getEmail().equals(email))
                        .findFirst()
                        .get()
                        .getId()
        );
    }
}
