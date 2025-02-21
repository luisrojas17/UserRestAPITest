package com.example.api.controller;

import com.example.api.controller.model.User;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }

    @GetMapping(value = "/users2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUsers2() {
        return ResponseEntity.ok().body(userService.getUsers2());
     }

}
