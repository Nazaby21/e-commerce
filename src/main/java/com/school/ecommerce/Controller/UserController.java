package com.school.ecommerce.Controller;


import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Request.UpdateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;
import com.school.ecommerce.Mapper.UserMapper;
import com.school.ecommerce.Service.UserService;
import com.school.ecommerce.Vo.Request.CreateUserRequestVo;
import com.school.ecommerce.Vo.Request.UpdateUserRequestVo;
import com.school.ecommerce.Vo.Response.UserResponseVo;
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
    public UserResponseVo createUser(@Valid @RequestBody CreateUserRequestVo createUserRequestVo) {
        CreateUserRequestDto createUserRequestDto = userMapper.createdUserVoToDto(createUserRequestVo);
        UserResponseDto userResponseDto = userService.createUser(createUserRequestDto);
        return userMapper.userDtoToVo(userResponseDto);
    }

    @GetMapping("/{id}")
    public UserResponseVo getUserById(@PathVariable Long id){
        return userMapper.userDtoToVo(userService.getUserById(id));
    }

    @GetMapping
    public List<UserResponseVo> getAllUsers(){
        return userService.getAllUsers()
                .stream()
                .map(userMapper::userDtoToVo)
                .toList();
    }

    @PutMapping("/{id}")
    public UserResponseVo updatedUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequestVo updateUserRequestVo) {
        UpdateUserRequestDto updateUserRequestDto = userMapper.updateUserVoToDto(updateUserRequestVo);
        UserResponseDto userResponseDto = userService.updateUser(id, updateUserRequestDto);
        return userMapper.userDtoToVo(userResponseDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User has been deleted";
    }
}
