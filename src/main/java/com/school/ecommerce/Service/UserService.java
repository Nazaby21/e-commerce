package com.school.ecommerce.Service;

import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Request.UpdateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto);
    void deleteUser(Long id);
}
