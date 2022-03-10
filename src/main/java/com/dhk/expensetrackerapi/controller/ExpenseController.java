package com.dhk.expensetrackerapi.controller;

import com.dhk.expensetrackerapi.controller.dto.ExpenseAssembler;
import com.dhk.expensetrackerapi.controller.dto.request.ExpenseRequest;
import com.dhk.expensetrackerapi.controller.dto.response.ExpenseResponse;
import com.dhk.expensetrackerapi.service.ExpenseService;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping(value = "/expenses")
@RequiredArgsConstructor
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;
    private static final String REDIRECT_URL = "/api/v1/expenses/";

    @GetMapping
    public Page<ExpenseResponseDto> getAllExpenses(Pageable pageable) {
        return expenseService.getAllExpenses(pageable);
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponse> getExpense(@PathVariable Long expenseId) {
        ExpenseResponseDto responseDto = expenseService.getExpense(expenseId);

        return ResponseEntity.ok(ExpenseAssembler.toExpenseResponse(responseDto));
    }

    @PostMapping
    public ResponseEntity<Long> saveExpense(@RequestBody ExpenseRequest request) {
        ExpenseRequestDto expenseRequestDto = ExpenseAssembler.toExpenseRequestDto(request);
        Long id = expenseService.saveExpense(expenseRequestDto);

        return ResponseEntity.created(URI.create(REDIRECT_URL + id)).build();
    }

    @DeleteMapping
    public void deleteExpense(@RequestParam Long expenseId) {
        expenseService.deleteExpense(expenseId);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<Long> updateExpenseV2(@PathVariable Long expenseId, @RequestBody ExpenseRequest request) {
        ExpenseRequestDto expenseRequestDto = ExpenseAssembler.toExpenseRequestDto(request);
        expenseService.updateExpense(expenseId, expenseRequestDto);

        return ResponseEntity.ok(expenseId);
    }
}


