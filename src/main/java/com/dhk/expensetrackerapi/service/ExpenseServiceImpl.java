package com.dhk.expensetrackerapi.service;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.exception.exceptions.ResourceNotFoundException;
import com.dhk.expensetrackerapi.repository.ExpenseRepository;
import com.dhk.expensetrackerapi.service.dto.ExpenseDtoAssembler;
import com.dhk.expensetrackerapi.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public Page<ExpenseResponseDto> getAllExpenses(Pageable pageable) {
        return expenseRepository.findAllExpense(pageable);
    }

    @Override
    public ExpenseResponseDto getExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("Expense is not found. id=" + id);
                }
        );

        return ExpenseDtoAssembler.toExpenseResponseDto(expense);
    }

    @Transactional
    @Override
    public Long saveExpense(ExpenseRequestDto expenseRequestDto) {
        Expense expense = ExpenseDtoAssembler.toExpenseEntity(expenseRequestDto);
        Expense savedExpense = expenseRepository.save(expense);

        return savedExpense.getId();
    }

    @Transactional
    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateExpense(Long id, ExpenseRequestDto expenseRequestDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("Expense is not found. id=" + id);
                });

        Expense newExpense = new Expense(
                Objects.isNull(expenseRequestDto.getName()) ? expense.getName() : expenseRequestDto.getName(),
                Objects.isNull(expenseRequestDto.getDescription()) ? expense.getDescription() : expenseRequestDto.getDescription(),
                Objects.isNull(expenseRequestDto.getAmount()) ? expense.getAmount() : expenseRequestDto.getAmount(),
                Objects.isNull(expenseRequestDto.getCategory()) ? expense.getCategory() : expenseRequestDto.getCategory(),
                Objects.isNull(expenseRequestDto.getDate()) ? expense.getDate() : expenseRequestDto.getDate()
        );

        expense.update(newExpense);
    }


}
