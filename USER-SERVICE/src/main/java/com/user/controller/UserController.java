package com.user.controller;

import com.user.entities.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> loadAllUsers() {
        List<User> users = userService.loadAllUsers();
        if (users.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.loadAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> loadUserById(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.loadUserById(userId));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


}
