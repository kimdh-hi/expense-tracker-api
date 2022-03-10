package com.dhk.expensetrackerapi.service.dto;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;

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
}
