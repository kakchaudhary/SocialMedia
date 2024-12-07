package com.example.SocialMedia.Controllers;


import com.example.SocialMedia.Services.UserService;

public class SocialMediaController {
    private final UserService userService;

    public SocialMediaController(UserService userService) {
        this.userService = userService;
    }

    public void handleRegisterUser(int userId, String username) {
        String result = userService.registerUser(userId, username);
        System.out.println(result);
    }
}
