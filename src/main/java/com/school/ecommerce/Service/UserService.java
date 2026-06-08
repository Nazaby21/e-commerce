package com.school.ecommerce.Service;

import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
    UserResponseDto getUserByIdAndEmail(Long id,  String email);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, CreateUserRequestDto createUserRequestDto);
    void deleteUser(Long id);
}
