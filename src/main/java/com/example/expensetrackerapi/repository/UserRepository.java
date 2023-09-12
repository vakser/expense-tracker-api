package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
