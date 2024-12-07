package com.example.SocialMedia.Models;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int userId;
	private String username;
	private Set<Integer> following = new HashSet<>();

	public void followUser(int userId) {
		following.add(userId);
	}

	public void unfollowUser(int userId) {
		following.remove(userId);
	}
}
