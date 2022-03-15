package com.dhk.expensetrackerapi.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TokenResponse {

    private final String token;
}
