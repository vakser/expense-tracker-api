package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.entity.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
}
