package com.dhk.expensetrackerapi.service.dto;

import com.dhk.expensetrackerapi.entity.Expense;

public class ExpenseRequestDtoAssembler {

    private ExpenseRequestDtoAssembler() {}

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
}
