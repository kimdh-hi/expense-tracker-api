package com.dhk.expensetrackerapi.expense.service;

import com.dhk.expensetrackerapi.expense.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.PageResponseDto;
import com.dhk.expensetrackerapi.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ExpenseService {

    PageResponseDto<ExpenseResponseDto> getExpenses(User user, Pageable pageable);

    PageResponseDto<ExpenseResponseDto> getExpensesByCategory(String category, Pageable pageable, User user);

    PageResponseDto<ExpenseResponseDto> getExpensesByName(String name, Pageable pageable, User user);

    PageResponseDto<ExpenseResponseDto> getExpensesByDate(LocalDate startDate, LocalDate endDate, Pageable pageable, User user);

    ExpenseResponseDto getExpense(Long id, User user);

    Long saveExpense(ExpenseRequestDto expenseRequestDto, User user);

    void deleteExpense(Long id, User user);

    void updateExpense(Long id, ExpenseRequestDto expenseRequestDto, User user);
}
