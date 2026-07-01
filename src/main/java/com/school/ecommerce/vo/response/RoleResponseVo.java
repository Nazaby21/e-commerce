package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RoleResponseVo(
        Long id,
        @JsonProperty("role_name")
        String roleName,
        String description
) {
}
