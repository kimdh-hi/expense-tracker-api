package com.dhk.expensetrackerapi.repository;

import com.dhk.expensetrackerapi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


}
