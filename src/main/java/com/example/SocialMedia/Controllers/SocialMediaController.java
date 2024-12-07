package com.example.SocialMedia.Controllers;

import com.example.SocialMedia.Services.PostService;
import com.example.SocialMedia.Services.UserService;

public class SocialMediaController {
	private final UserService userService;
	private final PostService postService;

	public SocialMediaController(UserService userService, PostService postService) {
		this.userService = userService;
		this.postService = postService;
	}

	public void handleRegisterUser(int userId, String username) {
		String result = userService.registerUser(userId, username);
		System.out.println(result);
	}

	public void handleUploadPost(int userId, String content) {
		String result = postService.uploadPost(userId, content);
		System.out.println(result);
	}
}
