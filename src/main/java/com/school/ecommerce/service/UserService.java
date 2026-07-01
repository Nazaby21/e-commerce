package com.school.ecommerce.service;

import com.school.ecommerce.dto.request.CreateUserRequestDto;
import com.school.ecommerce.dto.request.UpdateUserRequestDto;
import com.school.ecommerce.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto);
    void deleteUser(Long id);
}
