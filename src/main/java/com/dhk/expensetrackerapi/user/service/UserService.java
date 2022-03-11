package com.dhk.expensetrackerapi.user.service;

import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;

public interface UserService {

    Long createUser(UserRequestDto userRequestDto);
}
