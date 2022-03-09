package com.dhk.expensetrackerapi.service;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.repository.ExpenseRepository;
import com.dhk.expensetrackerapi.service.dto.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.ExpenseRequestDtoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpense(Long id) {
        return expenseRepository.findById(id).orElseThrow(
                () -> {throw new IllegalArgumentException("Expense is not found. id=" + id);}
        );
    }

    @Transactional
    @Override
    public Long saveExpense(ExpenseRequestDto expenseRequestDto) {
        Expense expense = ExpenseRequestDtoAssembler.toExpenseEntity(expenseRequestDto);
        Expense savedExpense = expenseRepository.save(expense);

        return savedExpense.getId();
    }

    @Transactional
    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
