package com.example.expensetrackerapi.repository;

import com.example.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Page<Expense> findByCategory(String category, Pageable page);

    Page<Expense> findByNameContaining(String keyword, Pageable page);

    Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);

    Page<Expense> findByUserId(Long userId, Pageable pageable);
}
