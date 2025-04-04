package com.feiyi.heritage.service;

import com.feiyi.heritage.entity.User;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> login(String username, String password);
    Optional<User> getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
} 