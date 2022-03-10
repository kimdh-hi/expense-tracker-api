package com.dhk.expensetrackerapi.repository;

import com.dhk.expensetrackerapi.entity.Expense;
import com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("select new com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto(e.id, e.name, e.description, e.amount, e.category, e.date, e.createdAt, e.updatedAt) from Expense e ")
    Page<ExpenseResponseDto> findAllExpense(Pageable pageable);
}
