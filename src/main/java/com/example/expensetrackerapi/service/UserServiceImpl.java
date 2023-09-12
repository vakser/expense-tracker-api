package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.entity.User;
import com.example.expensetrackerapi.entity.UserModel;
import com.example.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.example.expensetrackerapi.exceptions.ResourceNotFoundException;
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

    @Override
    public User readUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id " + id));
    }

    @Override
    public User updateUser(UserModel user, Long id) {
        User existingUser = readUser(id);
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = readUser(id);
        userRepository.delete(existingUser);
    }
}
