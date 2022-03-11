package com.dhk.expensetrackerapi.expense.service.dto;

import com.dhk.expensetrackerapi.expense.entity.Expense;
import com.dhk.expensetrackerapi.expense.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.PageResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDtoAssembler {

    private ExpenseDtoAssembler() {}

    public static Expense toExpenseEntity(ExpenseRequestDto dto) {
        return new Expense(
                dto.getName(),
                dto.getDescription(),
                dto.getAmount(),
                dto.getCategory(),
                dto.getDate()
        );
    }

    public static ExpenseRequestDto toExpenseRequestDto(Expense expense) {
        return new ExpenseRequestDto(
                expense.getName(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDate()
        );
    }

    public static ExpenseResponseDto toExpenseResponseDto(Expense expense) {
        return new ExpenseResponseDto(
                expense.getId(),
                expense.getName(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDate(),
                expense.getCreatedAt(),
                expense.getUpdatedAt()
        );
    }

    public static PageResponseDto<ExpenseResponseDto> toPageResponseDto(Page<Expense> expensePage) {
        PageResponseDto<ExpenseResponseDto> expenses = new PageResponseDto<>();

        List<ExpenseResponseDto> expenseResponseDtos = expensePage.getContent().stream()
                .map(ExpenseDtoAssembler::toExpenseResponseDto)
                .collect(Collectors.toList());
        expenses.setContent(expenseResponseDtos);

        expenses.setPage(expensePage.getNumber());
        expenses.setSize(expensePage.getSize());
        expenses.setLastPage(expensePage.isLast());
        expenses.setTotalPages(expensePage.getTotalPages());
        expenses.setTotalElements(expensePage.getTotalElements());

        return expenses;
    }
}
