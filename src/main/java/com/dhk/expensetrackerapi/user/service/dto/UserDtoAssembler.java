package com.dhk.expensetrackerapi.user.service.dto;

import com.dhk.expensetrackerapi.user.entity.User;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.response.UserResponseDto;

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

    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );

        return userResponseDto;
    }
}
