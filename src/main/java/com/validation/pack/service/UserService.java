package com.validation.pack.service;
import com.validation.pack.entity.User;

public interface UserService {
    void registerUser(User user);
    
    boolean validateUser(String username, String password);
    boolean isUserExists(String username);
}
