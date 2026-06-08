package com.school.ecommerce.Controller;


import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;
import com.school.ecommerce.Mapper.UserMapper;
import com.school.ecommerce.Service.UserService;
import com.school.ecommerce.Vo.Request.CreateUserRequestVo;
import com.school.ecommerce.Vo.Response.UserResponseVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
