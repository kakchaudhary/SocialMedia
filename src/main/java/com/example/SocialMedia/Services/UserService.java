package com.example.SocialMedia.Services;


import java.util.HashSet;

import com.example.SocialMedia.Models.User;
import com.example.SocialMedia.Repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(int userId, String username) {
        if (userRepository.userExists(userId)) {
            return "User ID already exists!";
        }
        User user = new User(userId, username,new HashSet<>());
        userRepository.addUser(user);
        return username + " Registered!!";
    }
}
