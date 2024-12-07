package com.example.SocialMedia;

import com.example.SocialMedia.Controllers.SocialMediaController;
import com.example.SocialMedia.Repository.UserRepository;
import com.example.SocialMedia.Services.UserService;

public class Main {
	public static void main(String[] args) {
		UserRepository userRepository = new UserRepository();
		UserService userService = new UserService(userRepository);
		SocialMediaController controller = new SocialMediaController(userService);

		controller.handleRegisterUser(1, "Akash"); // op: Akash Registered!!
		controller.handleRegisterUser(2, "Hemant"); // op: Hemant Registered!!
		controller.handleRegisterUser(1, "DuplicateUser"); // op: User ID already exists!

	}
}
