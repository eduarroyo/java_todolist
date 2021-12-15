package com.eduarroyo.todolist.controller;

import java.util.Optional;

import com.eduarroyo.todolist.dto.UserSignUpDto;
import com.eduarroyo.todolist.entity.User;
import com.eduarroyo.todolist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Create new user
    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody UserSignUpDto user) {

        User usr = new User(user.getLogin());
        usr.setEmail(user.getLogin());
        usr.setEnabled(true);
        usr.setFirstName("");
        usr.setLastName("");
        usr.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.save(usr));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable(value="id") Long userId) {
        Optional<User> oUser = userService.findById(userId);

        if(oUser.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
        }
            
        return ResponseEntity.ok(oUser.get());
    }
}