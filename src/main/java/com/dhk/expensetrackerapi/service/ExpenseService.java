package com.dhk.expensetrackerapi.service;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();
    ExpenseResponseDto getExpense(Long id);
    Long saveExpense(ExpenseRequestDto expenseRequestDto);
    void deleteExpense(Long id);
    void updateExpense(Long id, ExpenseRequestDto expenseRequestDto);
}
