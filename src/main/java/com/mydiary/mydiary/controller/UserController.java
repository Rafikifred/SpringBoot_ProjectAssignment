package com.mydiary.mydiary.controller;

import com.mydiary.mydiary.model.User;
import com.mydiary.mydiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody User user) {

        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(401).body("Email already exists");
        }


        User savedUser = userService.save(user);
        return ResponseEntity.status(201).body(savedUser);
    }


    @PostMapping("/signin")
    public ResponseEntity<Object> signIn(@RequestBody User user) {
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isEmpty() || !existingUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok(existingUser.get());
    }
}
