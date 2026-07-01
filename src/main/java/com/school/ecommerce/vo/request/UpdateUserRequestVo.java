package com.school.ecommerce.vo.request;

import com.school.ecommerce.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        Gender gender
) {
}
