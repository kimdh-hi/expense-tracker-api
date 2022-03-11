package com.dhk.expensetrackerapi.repository;

import com.dhk.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Page<Expense> findAll(Pageable pageable);
    Page<Expense> findByCategory(String category, Pageable pageable);
    Page<Expense> findByNameContaining(String name, Pageable pageable);

//    @Query("select new com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto(e.id, e.name, e.description, e.amount, e.category, e.date, e.createdAt, e.updatedAt) from Expense e ")
//    Page<ExpenseResponseDto> findAllExpense(Pageable pageable);
//
//    @Query("select new com.dhk.expensetrackerapi.service.dto.response.ExpenseResponseDto (e.id, e.name, e.description, e.amount, e.category, e.date, e.createdAt, e.updatedAt) from Expense e " +
//            "where e.category = :category")
//    Page<ExpenseResponseDto> findByCategory(@Param("category") String category, Pageable pageable);

}
