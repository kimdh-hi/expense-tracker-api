package com.dhk.expensetrackerapi.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "User name must not be empty.")
    private String name;
    @Email
    @NotBlank(message = "User email must not be empty.")
    private String email;
    @Size(min = 8, max = 16)
    @NotBlank(message = "User password must not be empty.")
    private String password;
    @NotNull(message = "User age must not be null")
    private int age;

}
