package com.dhk.expensetrackerapi.controller;

import com.dhk.expensetrackerapi.controller.dto.ExpenseAssembler;
import com.dhk.expensetrackerapi.controller.dto.request.ExpenseRequest;
import com.dhk.expensetrackerapi.service.ExpenseService;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.service.dto.response.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;

@RequestMapping(value = "/expenses")
@RequiredArgsConstructor
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;
    private static final String REDIRECT_URL = "/api/v1/expenses/";

    @GetMapping
    public ResponseEntity<PageResponseDto<ExpenseResponseDto>> getAllExpenses(Pageable pageable) {
        return ResponseEntity.ok(expenseService.getExpenses(pageable));
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDto> getExpense(@PathVariable Long expenseId) {
        ExpenseResponseDto responseDto = expenseService.getExpense(expenseId);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<Long> saveExpense(@Valid @RequestBody ExpenseRequest request) {
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

    @GetMapping("/category")
    public ResponseEntity<PageResponseDto<ExpenseResponseDto>> findAllExpensesByCategory(@RequestParam String category, Pageable pageable) {

        return ResponseEntity.ok(expenseService.getExpensesByCategory(category, pageable));
    }

    @GetMapping("/name")
    public ResponseEntity<PageResponseDto<ExpenseResponseDto>> findAllExpensesByName(@RequestParam String name, Pageable pageable) {

        return ResponseEntity.ok(expenseService.getExpensesByName(name, pageable));
    }

    @GetMapping("/date")
    public ResponseEntity<PageResponseDto<ExpenseResponseDto>> findAllExpensesByDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate start,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate end, Pageable pageable) {

        return ResponseEntity.ok(expenseService.getExpensesByDate(start, end, pageable));
    }
}


