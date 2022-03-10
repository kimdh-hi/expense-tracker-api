package com.dhk.expensetrackerapi.controller.dto;

import com.dhk.expensetrackerapi.controller.dto.request.ExpenseRequest;
import com.dhk.expensetrackerapi.controller.dto.response.ExpenseResponse;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;

public class ExpenseAssembler {

    private ExpenseAssembler() {}

    public static ExpenseRequestDto toExpenseRequestDto(ExpenseRequest request) {
        return new ExpenseRequestDto(
                request.getName(),
                request.getDescription(),
                request.getAmount(),
                request.getCategory(),
                request.getDate()
        );
    }

    public static ExpenseResponse toExpenseResponse(ExpenseResponseDto dto) {
        return new ExpenseResponse(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getAmount(),
                dto.getCategory(),
                dto.getDate(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
