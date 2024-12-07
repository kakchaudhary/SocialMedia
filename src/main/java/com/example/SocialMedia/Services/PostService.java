package com.example.SocialMedia.Services;


import com.example.SocialMedia.Models.Post;
import com.example.SocialMedia.Repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String uploadPost(int userId, String content) {
        Post post = postRepository.addPost(userId, content);
        return "Upload Successful with post id: " + String.format("%03d", post.getPostId());
    }
}

