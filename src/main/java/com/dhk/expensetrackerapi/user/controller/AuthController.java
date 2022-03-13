package com.dhk.expensetrackerapi.user.controller;

import com.dhk.expensetrackerapi.user.controller.dto.request.LoginRequest;
import com.dhk.expensetrackerapi.user.controller.dto.UserAssembler;
import com.dhk.expensetrackerapi.user.controller.dto.request.UserRequest;
import com.dhk.expensetrackerapi.user.service.AuthService;
import com.dhk.expensetrackerapi.user.service.dto.request.LoginRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginRequestDto loginRequestDto = UserAssembler.toLoginRequestDto(loginRequest);
        authService.login(loginRequestDto);

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@Valid @RequestBody UserRequest userRequest) {
        UserRequestDto userRequestDto = UserAssembler.toUserRequestDto(userRequest);
        Long userId = authService.register(userRequestDto);

        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }
}
