package com.dhk.expensetrackerapi.controller.dto;

import com.dhk.expensetrackerapi.controller.dto.request.ExpenseRequest;
import com.dhk.expensetrackerapi.service.dto.ExpenseRequestDto;

public class ExpenseRequestAssembler {

    private ExpenseRequestAssembler() {}

    public static ExpenseRequestDto toExpenseRequestDto(ExpenseRequest request) {
        return new ExpenseRequestDto(
                request.getName(),
                request.getDescription(),
                request.getAmount(),
                request.getCategory(),
                request.getDate()
        );
    }
}
