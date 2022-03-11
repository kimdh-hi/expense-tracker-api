package com.dhk.expensetrackerapi.user.service.dto;

import com.dhk.expensetrackerapi.user.entity.User;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;

public class UserDtoAssembler {

    public static User toUserEntity(UserRequestDto dto) {
        User user = new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getAge()
        );

        return user;
    }
}
