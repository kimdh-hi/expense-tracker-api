package com.dhk.expensetrackerapi.user.service;

import com.dhk.expensetrackerapi.user.service.dto.request.LoginRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;

public interface AuthService {

    Long register(UserRequestDto userRequestDto);

    void login(LoginRequestDto loginRequestDto);
}
