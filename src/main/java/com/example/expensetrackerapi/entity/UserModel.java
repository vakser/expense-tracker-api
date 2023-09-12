package com.example.expensetrackerapi.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModel {
    @NotBlank(message = "Name must not be empty")
    private String name;
    @NotNull(message = "Email must not be empty")
    @Email(message = "Enter a valid email")
    private String email;
    @NotNull(message = "Password must not be empty")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;
    private Long age = 0L;
}
