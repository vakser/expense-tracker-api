package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.entity.User;
import com.example.expensetrackerapi.entity.UserModel;
import com.example.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.example.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExistsException("User with email " + user.getEmail() + " is already registered");
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        return userRepository.save(newUser);
    }
}
