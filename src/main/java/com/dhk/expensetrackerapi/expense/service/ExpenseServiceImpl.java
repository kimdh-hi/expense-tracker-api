package com.dhk.expensetrackerapi.expense.service;

import com.dhk.expensetrackerapi.expense.entity.Expense;
import com.dhk.expensetrackerapi.exception.exceptions.ResourceNotFoundException;
import com.dhk.expensetrackerapi.expense.repository.ExpenseRepository;
import com.dhk.expensetrackerapi.expense.service.dto.ExpenseDtoAssembler;
import com.dhk.expensetrackerapi.expense.service.dto.request.ExpenseRequestDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public PageResponseDto<ExpenseResponseDto> getExpenses(Pageable pageable) {
        Page<Expense> expensePage = expenseRepository.findAll(pageable);

        return ExpenseDtoAssembler.toPageResponseDto(expensePage);
    }

    @Override
    public PageResponseDto<ExpenseResponseDto> getExpensesByCategory(String category, Pageable pageable) {
        Page<Expense> expensePage = expenseRepository.findByCategory(category, pageable);

        return ExpenseDtoAssembler.toPageResponseDto(expensePage);
    }

    @Override
    public PageResponseDto<ExpenseResponseDto> getExpensesByName(String name, Pageable pageable) {
        Page<Expense> expensePage = expenseRepository.findByNameContaining(name, pageable);

        return ExpenseDtoAssembler.toPageResponseDto(expensePage);
    }

    @Override
    public PageResponseDto<ExpenseResponseDto> getExpensesByDate(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("시작날짜가 끝날짜보다 늦을 수 없습니다. 시작날짜: "+startDate.toString() + " 끝날짜: " + endDate.toString());
        }

        Page<Expense> expensePage = expenseRepository.findByDateBetween(startDate, endDate, pageable);

        return ExpenseDtoAssembler.toPageResponseDto(expensePage);
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
        Expense expense = expenseRepository.findById(id).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("Expense is not found. id=" + id);
                }
        );

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
