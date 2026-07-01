package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        @NotBlank(message = "Please input your password")
        String password,
//        @NotEmpty(message = "Please set your role")
        @JsonProperty("role_id")
        Long roleId,
//        @NotEmpty(message = "Please choose your gender")
        Gender gender
) {
}
