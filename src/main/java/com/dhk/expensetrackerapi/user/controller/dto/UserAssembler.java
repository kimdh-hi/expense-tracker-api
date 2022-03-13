package com.dhk.expensetrackerapi.user.controller.dto;

import com.dhk.expensetrackerapi.user.controller.dto.request.LoginRequest;
import com.dhk.expensetrackerapi.user.controller.dto.request.UserRequest;
import com.dhk.expensetrackerapi.user.controller.dto.response.UserResponse;
import com.dhk.expensetrackerapi.user.service.dto.request.LoginRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.response.UserResponseDto;

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

    public static UserResponse toUserResponse(UserResponseDto dto) {
        UserResponse userResponse = new UserResponse(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getAge(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );

        return userResponse;
    }

    public static LoginRequestDto toLoginRequestDto(LoginRequest request) {
        LoginRequestDto loginRequestDto = new LoginRequestDto(
                request.getEmail(), request.getPassword()
        );

        return loginRequestDto;
    }
}
