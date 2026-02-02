package com.dextero.user_management.service;

import java.util.List;

import com.dextero.user_management.entity.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}
