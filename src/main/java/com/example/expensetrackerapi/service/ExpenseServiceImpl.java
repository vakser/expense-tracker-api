package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.entity.Expense;
import com.example.expensetrackerapi.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
