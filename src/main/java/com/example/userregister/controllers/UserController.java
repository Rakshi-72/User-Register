package com.example.userregister.controllers;

import com.example.userregister.UserRepo;
import com.example.userregister.models.LoginModal;
import com.example.userregister.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepo repo;

    public UserController(UserRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        User savedUser = repo.save(user);
        return "user registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginModal login) {
        User u = repo.findByEmail(login.getUserName()).orElseThrow(() -> new RuntimeException("username password miss match"));
        boolean b = u.getPassword().equals(login.getPassword());
        if (b)
            return "logging in successfully";
        else return "username or password mismatch";
    }

}
