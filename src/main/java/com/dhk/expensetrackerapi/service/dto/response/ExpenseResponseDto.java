package com.dhk.expensetrackerapi.service.dto.response;

import java.time.LocalDate;

public class ExpenseResponseDto {

    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private String category;
    private LocalDate date;

    public ExpenseResponseDto() {
    }

    public ExpenseResponseDto(Long id, String name, String description, Integer amount, String category, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
