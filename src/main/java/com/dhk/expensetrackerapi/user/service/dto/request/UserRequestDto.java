package com.dhk.expensetrackerapi.user.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String name;
    private String email;
    private String password;
    private Integer age;

}
