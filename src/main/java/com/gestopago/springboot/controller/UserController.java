package com.gestopago.springboot.controller;

import com.gestopago.springboot.model.User;
import com.gestopago.springboot.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;
    private final PasswordEncoder bCryptEncoder;

    public UserController(UserServiceImpl userService, PasswordEncoder bCryptEncoder) {
        this.userService = userService;
        this.bCryptEncoder = bCryptEncoder;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        User userCreated = userService.saveUser(user);
        return userCreated == null
                ? new ResponseEntity<>(userCreated, HttpStatus.CONFLICT)
                : new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id
            , @RequestBody User user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
