package com.mitesh.SpringSecurity.Controller;

import com.mitesh.SpringSecurity.Service.UserService;
import com.mitesh.SpringSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }
}
