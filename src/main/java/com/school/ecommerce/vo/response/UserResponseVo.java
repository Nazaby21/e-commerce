package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;

public record UserResponseVo(
        Long id,
        String username,
        String email,
        @JsonProperty("role_name")
        String roleName,
        Gender gender
) {
}
