package com.example.SocialMedia.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int postId;
    private int userId;
    private String content;
    private LocalDateTime timestamp = LocalDateTime.now();
    private int likes = 0;
    private int dislikes = 0;

    public void likePost() {
        likes++;
    }

    public void dislikePost() {
        dislikes++;
    }
}
