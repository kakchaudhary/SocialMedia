package com.example.SocialMedia.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.SocialMedia.Models.Post;

public class PostRepository {
    private Map<Integer, Post> posts = new HashMap<>();
    private int postCounter = 0;

    public Post addPost(int userId, String content) {
        postCounter++;
        Post post = new Post(postCounter, userId, content,LocalDateTime.now(),0,0);
        posts.put(postCounter, post);
        return post;
    }

    public Post getPostById(int postId) {
        return posts.get(postId);
    }
}
