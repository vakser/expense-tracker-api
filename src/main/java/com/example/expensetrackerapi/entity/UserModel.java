package com.example.expensetrackerapi.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
