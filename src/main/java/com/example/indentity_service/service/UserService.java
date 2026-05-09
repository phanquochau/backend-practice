package com.example.indentity_service.service;

import com.example.indentity_service.dto.dtorequest.UserCreationRequest;
import com.example.indentity_service.dto.dtorequest.UserUpdateRequest;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        if (userRepository.existsUserByUsername(request.getUsername())){
            throw new RuntimeException("User existed");
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userID, UserUpdateRequest request){
        User user = getUser(userID);
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }
    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }
}
