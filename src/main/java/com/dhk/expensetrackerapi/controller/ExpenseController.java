package com.dhk.expensetrackerapi.controller;

import com.dhk.expensetrackerapi.controller.dto.ExpenseRequestAssembler;
import com.dhk.expensetrackerapi.controller.dto.request.ExpenseRequest;
import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.service.ExpenseService;
import com.dhk.expensetrackerapi.service.dto.ExpenseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/expenses")
@RequiredArgsConstructor
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{expenseId}")
    public Expense getExpense(@PathVariable Long expenseId) {
        return expenseService.getExpense(expenseId);
    }

    @PostMapping
    public Long saveExpense(@RequestBody ExpenseRequest request) {
        ExpenseRequestDto expenseRequestDto = ExpenseRequestAssembler.toExpenseRequestDto(request);
        Long id = expenseService.saveExpense(expenseRequestDto);
        return id;
    }

    @DeleteMapping
    public void deleteExpense(@RequestParam Long expenseId) {
        expenseService.deleteExpense(expenseId);
    }
}


