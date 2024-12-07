package com.example.SocialMedia.Repository;

import java.util.HashMap;
import java.util.Map;

import com.example.SocialMedia.Models.User;

public class UserRepository {
    private Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }

    public boolean userExists(int userId) {
        return users.containsKey(userId);
    }
}
