package com.school.ecommerce.Vo.Request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequestVo(
        @NotBlank(message = "Role name is require")
        String roleName
) {
}
