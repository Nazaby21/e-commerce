package com.school.ecommerce.controller;


import com.school.ecommerce.dto.request.CreateUserRequestDto;
import com.school.ecommerce.dto.request.UpdateUserRequestDto;
import com.school.ecommerce.dto.response.UserResponseDto;
import com.school.ecommerce.exception.Dto.ApiResponse;
import com.school.ecommerce.mapper.UserMapper;
import com.school.ecommerce.service.UserService;
import com.school.ecommerce.vo.request.CreateUserRequestVo;
import com.school.ecommerce.vo.request.UpdateUserRequestVo;
import com.school.ecommerce.vo.response.UserResponseVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ApiResponse<UserResponseVo> createUser(@Valid @RequestBody CreateUserRequestVo createUserRequestVo) {
        CreateUserRequestDto createUserRequestDto = userMapper.createdUserVoToDto(createUserRequestVo);
        UserResponseDto userResponseDto = userService.createUser(createUserRequestDto);
        UserResponseVo userResponseVo = userMapper.userDtoToVo(userResponseDto);
        return ApiResponse.success(userResponseVo);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponseVo> getUserById(@PathVariable Long id){
        UserResponseVo userResponseVo = userMapper.userDtoToVo(userService.getUserById(id));
        return ApiResponse.success(userResponseVo);
    }

    @GetMapping
    public ApiResponse<List<UserResponseVo>> getAllUsers(){
        List<UserResponseVo> userResponseVo = userService.getAllUsers()
                .stream()
                .map(userMapper::userDtoToVo)
                .toList();
        return ApiResponse.success(userResponseVo);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponseVo> updatedUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequestVo updateUserRequestVo) {
        UpdateUserRequestDto updateUserRequestDto = userMapper.updateUserVoToDto(updateUserRequestVo);
        UserResponseDto userResponseDto = userService.updateUser(id, updateUserRequestDto);
        UserResponseVo userResponseVo = userMapper.userDtoToVo(userResponseDto);
        return ApiResponse.success(userResponseVo);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User has been deleted";
    }
}
