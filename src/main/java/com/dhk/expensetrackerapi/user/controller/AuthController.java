package com.dhk.expensetrackerapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("login success");
    }
}
