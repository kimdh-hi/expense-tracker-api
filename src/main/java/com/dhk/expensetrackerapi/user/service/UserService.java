package com.dhk.expensetrackerapi.user.service;

import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.response.UserResponseDto;

public interface UserService {

    Long createUser(UserRequestDto userRequestDto);

    UserResponseDto readUser(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);
}
