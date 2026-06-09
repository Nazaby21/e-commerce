package com.school.ecommerce.Vo.Request;

import com.school.ecommerce.Enumeration.Gender;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        Gender gender
) {
}
