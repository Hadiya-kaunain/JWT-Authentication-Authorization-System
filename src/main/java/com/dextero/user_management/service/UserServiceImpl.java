package com.dextero.user_management.service;
import com.dextero.user_management.exception.UserNotFoundException;
import com.dextero.user_management.exception.DuplicateUserException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dextero.user_management.entity.User;
import com.dextero.user_management.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {

    	if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateUserException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id));
    }
    

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    
}
