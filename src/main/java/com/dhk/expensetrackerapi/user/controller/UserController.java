package com.dhk.expensetrackerapi.user.controller;

import com.dhk.expensetrackerapi.security.CustomUserDetails;
import com.dhk.expensetrackerapi.user.controller.dto.UserAssembler;
import com.dhk.expensetrackerapi.user.controller.dto.request.UserRequest;
import com.dhk.expensetrackerapi.user.controller.dto.response.UserResponse;
import com.dhk.expensetrackerapi.user.service.UserService;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> readUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        UserResponseDto userResponseDto = userService.readUser(userDetails.getUser().getId());
        UserResponse userResponse = UserAssembler.toUserResponse(userResponseDto);

        return ResponseEntity.ok(userResponse);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(
            @AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody UserRequest userRequest) {

        UserRequestDto userRequestDto = UserAssembler.toUserRequestDto(userRequest);
        UserResponseDto userResponseDto = userService.updateUser(userDetails.getUser().getId(), userRequestDto);
        UserResponse userResponse = UserAssembler.toUserResponse(userResponseDto);

        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@AuthenticationPrincipal CustomUserDetails userDetails){

        userService.deleteUser(userDetails.getUser().getId());

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
