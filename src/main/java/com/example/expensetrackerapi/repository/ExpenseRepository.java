package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
