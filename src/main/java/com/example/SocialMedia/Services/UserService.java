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
		User user = new User(userId, username, new HashSet<>());
		userRepository.addUser(user);
		return username + " Registered!!";
	}

	public String followUser(int followerId, int followeeId) {
		User follower = userRepository.getUserById(followerId);
		User followee = userRepository.getUserById(followeeId);

		if (follower == null || followee == null) {
			return "One or both users do not exist!";
		}

		follower.followUser(followeeId);
		return "Followed " + followee.getUsername() + "!!";
	}

	public String unfollowUser(int followerId, int followeeId) {
		User follower = userRepository.getUserById(followerId);
		User followee = userRepository.getUserById(followeeId);

		if (follower == null || followee == null) {
			return "One or both users do not exist!";
		}

		follower.unfollowUser(followeeId);
		return "Unfollowed " + followee.getUsername() + "!!";
	}
}
