package com.shailesh.logbook.controller;

import com.shailesh.logbook.entity.User;
import com.shailesh.logbook.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
