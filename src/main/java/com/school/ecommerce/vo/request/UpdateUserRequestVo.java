package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequestVo(
        @NotBlank(message = "Please input your name")
        String username,
        @NotBlank(message = "Please input your email")
        String email,
        @JsonProperty("role_id")
        Long roleId,
        Gender gender
) {
}
