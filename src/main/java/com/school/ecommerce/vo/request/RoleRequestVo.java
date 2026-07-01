package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record RoleRequestVo(
        @JsonProperty("role_name")
        @NotBlank(message = "Role name is require")
        String roleName,
        String description
) {
}
