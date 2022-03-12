package com.dhk.expensetrackerapi.user.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private int age;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
