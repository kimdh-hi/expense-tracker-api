package com.dhk.expensetrackerapi.user.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private int age;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
