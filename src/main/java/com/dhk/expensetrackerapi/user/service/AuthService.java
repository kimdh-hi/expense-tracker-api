package com.dhk.expensetrackerapi.user.service;

import com.dhk.expensetrackerapi.security.jwt.TokenResponse;
import com.dhk.expensetrackerapi.user.service.dto.request.LoginRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;

public interface AuthService {

    Long register(UserRequestDto userRequestDto);

    TokenResponse login(LoginRequestDto loginRequestDto) throws Exception ;
}
