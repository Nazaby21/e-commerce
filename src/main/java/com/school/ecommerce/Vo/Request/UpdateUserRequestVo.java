package com.school.ecommerce.Vo.Request;

import com.school.ecommerce.Enumeration.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record UpdateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        @NotEmpty(message = "Please choose your gender")
        Gender gender
) {
}
