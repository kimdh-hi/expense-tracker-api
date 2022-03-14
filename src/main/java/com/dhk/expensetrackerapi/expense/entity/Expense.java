package com.dhk.expensetrackerapi.expense.entity;

import com.dhk.expensetrackerapi.common.entity.Timestamp;
import com.dhk.expensetrackerapi.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_expenses")
@Entity
public class Expense extends Timestamp {

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

    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, optional = false)
    private User user;

    public Expense(String name, String description, int amount, String category, LocalDate date, User user) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;

        this.user = user;
    }

    public void update(Expense newExpense) {
        this.name = newExpense.getName();;
        this.description = newExpense.getDescription();
        this.amount = newExpense.getAmount();
        this.category = newExpense.getCategory();;
        this.date = newExpense.getDate();
    }
}
