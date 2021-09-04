package com.example.siamtest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        int _id = -1;
        try{
            _id = Integer.parseInt(id);
        }catch (Exception e){
            throw  e;
        }
        return userService.findUserById(_id);
    }
}
