package com.dhk.expensetrackerapi.expense.service;

import com.dhk.expensetrackerapi.expense.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.PageResponseDto;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ExpenseService {

    PageResponseDto<ExpenseResponseDto> getExpenses(Pageable pageable);

    PageResponseDto<ExpenseResponseDto> getExpensesByCategory(String category, Pageable pageable);

    PageResponseDto<ExpenseResponseDto> getExpensesByName(String name, Pageable pageable);

    PageResponseDto<ExpenseResponseDto> getExpensesByDate(LocalDate startDate, LocalDate endDate, Pageable pageable);

    ExpenseResponseDto getExpense(Long id);

    Long saveExpense(ExpenseRequestDto expenseRequestDto);

    void deleteExpense(Long id);

    void updateExpense(Long id, ExpenseRequestDto expenseRequestDto);
}