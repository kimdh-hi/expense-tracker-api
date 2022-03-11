package com.dhk.expensetrackerapi.expense.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
