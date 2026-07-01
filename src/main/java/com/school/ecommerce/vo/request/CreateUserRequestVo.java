package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record CreateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        @NotBlank(message = "Please input your password")
        String password,
        @Positive(message = "Id must be bigger than 0")
        @JsonProperty("role_id")
        Long roleId,
        Gender gender
) {
}
