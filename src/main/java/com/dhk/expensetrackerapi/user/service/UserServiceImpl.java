package com.dhk.expensetrackerapi.user.service;

import com.dhk.expensetrackerapi.exception.exceptions.ItemAlreadyExistsException;
import com.dhk.expensetrackerapi.exception.exceptions.ResourceNotFoundException;
import com.dhk.expensetrackerapi.user.controller.dto.UserAssembler;
import com.dhk.expensetrackerapi.user.entity.User;
import com.dhk.expensetrackerapi.user.repository.UserRepository;
import com.dhk.expensetrackerapi.user.service.dto.UserDtoAssembler;
import com.dhk.expensetrackerapi.user.service.dto.request.UserRequestDto;
import com.dhk.expensetrackerapi.user.service.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public Long createUser(UserRequestDto userRequestDto) {
        emailDuplicateValidate(userRequestDto.getEmail());

        User user = UserDtoAssembler.toUserEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public UserResponseDto readUser(Long userId) {
        User user = findUserById(userId);

        return UserDtoAssembler.toUserResponseDto(user);
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        emailDuplicateValidate(userRequestDto.getEmail());

        User user = findUserById(userId);
        User newUser = new User(
                Objects.isNull(userRequestDto.getName()) ? user.getName() : userRequestDto.getName(),
                Objects.isNull(userRequestDto.getEmail()) ? user.getEmail() : userRequestDto.getEmail(),
                Objects.isNull(userRequestDto.getPassword()) ? user.getPassword() : userRequestDto.getPassword(),
                Objects.isNull(userRequestDto.getAge()) ? user.getAge() : userRequestDto.getAge()
        );
        user.update(newUser);

        return UserDtoAssembler.toUserResponseDto(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("User is not found. id=" + userId);
                }
        );
    }

    private void emailDuplicateValidate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ItemAlreadyExistsException("already exists email. email: " + email);
        }
    }
}
