package com.dhk.expensetrackerapi.user.controller;

import com.dhk.expensetrackerapi.user.controller.dto.UserAssembler;
import com.dhk.expensetrackerapi.user.controller.dto.request.UserRequest;
import com.dhk.expensetrackerapi.user.controller.dto.response.UserResponse;
import com.dhk.expensetrackerapi.user.service.UserService;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> readUser(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userService.readUser(userId);
        UserResponse userResponse = UserAssembler.toUserResponse(userResponseDto);

        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        UserRequestDto userRequestDto = UserAssembler.toUserRequestDto(userRequest);
        UserResponseDto userResponseDto = userService.updateUser(userId, userRequestDto);
        UserResponse userResponse = UserAssembler.toUserResponse(userResponseDto);

        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
