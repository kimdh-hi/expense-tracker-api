package com.dhk.expensetrackerapi.service;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {

    Page<ExpenseResponseDto> getAllExpenses(Pageable pageable);
    ExpenseResponseDto getExpense(Long id);
    Long saveExpense(ExpenseRequestDto expenseRequestDto);
    void deleteExpense(Long id);
    void updateExpense(Long id, ExpenseRequestDto expenseRequestDto);
}
