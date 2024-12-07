package com.example.SocialMedia;

import com.example.SocialMedia.Controllers.SocialMediaController;
import com.example.SocialMedia.Repository.PostRepository;
import com.example.SocialMedia.Repository.UserRepository;
import com.example.SocialMedia.Services.PostService;
import com.example.SocialMedia.Services.UserService;

public class Main {
	public static void main(String[] args) {
		UserRepository userRepository = new UserRepository();
		PostRepository postRepository = new PostRepository();
		UserService userService = new UserService(userRepository);
		PostService postService = new PostService(postRepository);
		SocialMediaController controller = new SocialMediaController(userService, postService);

		controller.handleRegisterUser(1, "Akash"); // op: Akash Registered!!
		controller.handleRegisterUser(2, "Hemant"); // op: Hemant Registered!!
		controller.handleRegisterUser(1, "DuplicateUser"); // op: User ID already exists!

		controller.handleUploadPost(1, "This is my first post."); // op: Upload Successful with post id: 001
		controller.handleUploadPost(2, "Hello! I'm Hemant."); // op: Upload Successful with post id: 002
		controller.handleUploadPost(1, "Another post by Akash."); // op: Upload Successful with post id: 003

	}
}
