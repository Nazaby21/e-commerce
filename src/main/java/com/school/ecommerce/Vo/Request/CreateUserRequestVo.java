package com.school.ecommerce.Vo.Request;

import com.school.ecommerce.Enumeration.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        @NotBlank(message = "Please input your password")
        String password,
//        @NotEmpty(message = "Please set your role")
        Long roleId,
//        @NotEmpty(message = "Please choose your gender")
        Gender gender
) {
}
