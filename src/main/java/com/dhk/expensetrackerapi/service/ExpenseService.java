package com.dhk.expensetrackerapi.service;

import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.service.dto.response.PageResponseDto;
import org.springframework.data.domain.Pageable;

public interface ExpenseService {

    PageResponseDto<ExpenseResponseDto> getAllExpenses(Pageable pageable);

    PageResponseDto<ExpenseResponseDto> getAllExpensesByCategory(String category, Pageable pageable);

    PageResponseDto<ExpenseResponseDto> getAllExpensesByName(String name, Pageable pageable);

    ExpenseResponseDto getExpense(Long id);

    Long saveExpense(ExpenseRequestDto expenseRequestDto);

    void deleteExpense(Long id);

    void updateExpense(Long id, ExpenseRequestDto expenseRequestDto);
}
