package com.example.SocialMedia.Controllers;

import java.util.List;

import com.example.SocialMedia.Models.Post;
import com.example.SocialMedia.Services.PostService;
import com.example.SocialMedia.Services.UserService;
import com.example.SocialMedia.Utils.TimeUtils;

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

	public void handleFollowUser(int followerId, int followeeId) {
		String result = userService.followUser(followerId, followeeId);
		System.out.println(result);
	}

	public void handleUnfollowUser(int followerId, int followeeId) {
		String result = userService.unfollowUser(followerId, followeeId);
		System.out.println(result);
	}

	public void handleShowFeed(int userId) {
		try {
			List<Post> feed = postService.getFeedForUser(userId);
			System.out.println("Feed for User ID: " + userId);
			for (Post post : feed) {
				System.out.println("User ID: " + post.getUserId());
				System.out.println("Post ID: " + post.getPostId());
				System.out.println("Content: " + post.getContent());
				System.out.println("Timestamp: " + TimeUtils.getRelativeTime(post.getTimestamp()));
				System.out.println();
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public void handleLikePost(int userId, int postId) {
		String result = postService.likePost(userId, postId);
		System.out.println(result);
	}

	public void handleDislikePost(int userId, int postId) {
		String result = postService.dislikePost(userId, postId);
		System.out.println(result);
	}
}
