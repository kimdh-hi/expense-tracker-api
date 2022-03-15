package com.dhk.expensetrackerapi.user.service;

import com.dhk.expensetrackerapi.exception.exceptions.ItemAlreadyExistsException;
import com.dhk.expensetrackerapi.security.CustomUserDetails;
import com.dhk.expensetrackerapi.security.CustomUserDetailsService;
import com.dhk.expensetrackerapi.security.jwt.JwtTokenProvider;
import com.dhk.expensetrackerapi.security.jwt.TokenResponse;
import com.dhk.expensetrackerapi.user.entity.User;
import com.dhk.expensetrackerapi.user.repository.UserRepository;
import com.dhk.expensetrackerapi.user.service.dto.UserDtoAssembler;
import com.dhk.expensetrackerapi.user.service.dto.request.LoginRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    @Transactional
    @Override
    public Long register(UserRequestDto userRequestDto) {
        emailDuplicateValidate(userRequestDto.getEmail());
        User user = UserDtoAssembler.toUserEntity(userRequestDto);
        encodePassword(user);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public TokenResponse login(LoginRequestDto loginRequestDto) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
        } catch (DisabledException ex) {
            throw new Exception("User disabled");
        } catch (BadCredentialsException ex) {
            throw new Exception("Bad credential");
        }

        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(loginRequestDto.getEmail());
        String token = jwtTokenProvider.generateToken(userDetails);

        return new TokenResponse(token);
    }

    private void emailDuplicateValidate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ItemAlreadyExistsException("already exists email. email: " + email);
        }
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
