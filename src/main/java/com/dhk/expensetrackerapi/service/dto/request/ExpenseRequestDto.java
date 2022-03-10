package com.dhk.expensetrackerapi.service.dto.request;

import com.dhk.expensetrackerapi.entity.Expense;

import java.time.LocalDate;

public class ExpenseRequestDto {

    private String name;
    private String description;
    private Integer amount;
    private String category;
    private LocalDate date;

    public ExpenseRequestDto() {
    }

    public ExpenseRequestDto(String name, String description, Integer amount, String category, LocalDate date) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SaveExpenseRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                '}';
    }
}
