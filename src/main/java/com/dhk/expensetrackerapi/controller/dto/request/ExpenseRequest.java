package com.dhk.expensetrackerapi.controller.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ExpenseRequest {

    @NotBlank(message = "Expense name must not be empty.")
    private String name;
    @NotBlank(message = "Expense description must not be empty.")
    private String description;
    @NotNull(message = "Expense amount must not be null.")
    private Integer amount;
    @NotBlank(message = "Expense category must not be empty")
    private String category;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Expense date must not be null")
    private LocalDate date;

    public ExpenseRequest(String name, String description, Integer amount, String category, LocalDate date) {
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
