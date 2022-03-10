package com.dhk.expensetrackerapi.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_expenses")
@Entity
public class Expense extends Timestamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "expense_name")
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "expense_amount")
    private int amount;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDate date;

    public Expense(String name, String description, int amount, String category, LocalDate date) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public void update(Expense newExpense) {
        this.name = newExpense.getName();;
        this.description = newExpense.getDescription();
        this.amount = newExpense.getAmount();
        this.category = newExpense.getCategory();;
        this.date = newExpense.getDate();
    }
}
