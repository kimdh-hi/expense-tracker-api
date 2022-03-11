package com.dhk.expensetrackerapi.user.controller.dto;

import com.dhk.expensetrackerapi.user.controller.dto.request.UserRequest;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;

public class UserAssembler {

    public static UserRequestDto toUserRequestDto(UserRequest request) {
        UserRequestDto userRequestDto = new UserRequestDto(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getAge()
        );

        return userRequestDto;
    }
}
