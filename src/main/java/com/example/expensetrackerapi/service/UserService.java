package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.entity.User;
import com.example.expensetrackerapi.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User readUser(Long id);

    User updateUser(UserModel user, Long id);

    void deleteUser(Long id);
}
