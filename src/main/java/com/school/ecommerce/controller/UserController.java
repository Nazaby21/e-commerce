package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.CreateUserRequestDto;
import com.school.ecommerce.dto.request.UpdateUserRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.UserResponseDto;
import com.school.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResponse<UserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(createUserRequestDto);
        return ApiResponse.success(userResponseDto);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        return ApiResponse.success(userResponseDto);
    }

    @GetMapping
    public ApiResponse<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ApiResponse.success(users);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponseDto> updatedUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(id, updateUserRequestDto);
        return ApiResponse.success(userResponseDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User has been deleted";
    }
}
