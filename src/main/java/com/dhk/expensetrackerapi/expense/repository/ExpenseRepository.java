package com.dhk.expensetrackerapi.expense.repository;

import com.dhk.expensetrackerapi.expense.entity.Expense;
import com.dhk.expensetrackerapi.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Page<Expense> findAllByUser(User user, Pageable pageable);
    Page<Expense> findByCategory(String category, Pageable pageable);
    Page<Expense> findByNameContaining(String name, Pageable pageable);
    Page<Expense> findByDateBetween(LocalDate start, LocalDate end, Pageable pageable);



//    @Query("select new com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto(e.id, e.name, e.description, e.amount, e.category, e.date, e.createdAt, e.updatedAt) from Expense e ")
//    Page<ExpenseResponseDto> findAllExpense(Pageable pageable);
//
//    @Query("select new com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto (e.id, e.name, e.description, e.amount, e.category, e.date, e.createdAt, e.updatedAt) from Expense e " +
//            "where e.category = :category")
//    Page<ExpenseResponseDto> findByCategory(@Param("category") String category, Pageable pageable);

}
