package com.example.SocialMedia.Services;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.SocialMedia.Models.Post;
import com.example.SocialMedia.Models.User;
import com.example.SocialMedia.Repository.PostRepository;
import com.example.SocialMedia.Repository.UserRepository;

public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public PostService(PostRepository postRepository,UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository=userRepository;
    }

    public String uploadPost(int userId, String content) {
        Post post = postRepository.addPost(userId, content);
        return "Upload Successful with post id: " + String.format("%03d", post.getPostId());
    }
    
    public List<Post> getFeedForUser(int userId) {
        User user = userRepository.getUserById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found!");
        }

        // Get all posts
        List<Post> allPosts = new ArrayList<>(postRepository.getAllPosts());

        // Separate followed and non-followed posts
        List<Post> followedPosts = allPosts.stream()
                .filter(post -> user.getFollowing().contains(post.getUserId()))
                .sorted(Comparator.comparing(Post::getTimestamp).reversed())
                .collect(Collectors.toList());

        List<Post> nonFollowedPosts = allPosts.stream()
                .filter(post -> !user.getFollowing().contains(post.getUserId()))
                .sorted(Comparator.comparing(Post::getTimestamp).reversed())
                .collect(Collectors.toList());

        // Combine followed and non-followed posts
        followedPosts.addAll(nonFollowedPosts);
        return followedPosts;
    }
}

