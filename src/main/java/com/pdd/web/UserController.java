package com.pdd.web;

import com.pdd.model.User;
import com.pdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdd")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/userinfo")
    private User getUserById(int uid) {
        return userService.getUserById(uid);
    }

    @PostMapping(value = "/adduser")
    private boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping(value = "/updateuser")
    private boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
