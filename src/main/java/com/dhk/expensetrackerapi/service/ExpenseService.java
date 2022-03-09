package com.dhk.expensetrackerapi.service;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.service.dto.ExpenseRequestDto;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();
    Expense getExpense(Long id);
    Long saveExpense(ExpenseRequestDto expenseRequestDto);
    void deleteExpense(Long id);
}
