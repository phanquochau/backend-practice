package com.example.indentity_service.controller;


import com.example.indentity_service.dto.dtorequest.UserCreationRequest;
import com.example.indentity_service.dto.dtorequest.UserUpdateRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }
    @GetMapping
    List<User> getUser(){
        return userService.getUser();
    }
    @GetMapping("/{userID}")
    User getUser(@PathVariable("userID") String userID){
        return userService.getUser(userID);
    }
    @PutMapping("/{userID}")
    public User updateUser(@PathVariable("userID") String userID, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userID, request);
    }
    @DeleteMapping("/{userID}")
    String deleteUser(@PathVariable String userID){
        userService.deleteUser(userID);
        return "User has been delete";
    }
}
