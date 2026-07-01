package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDto {
    Long id;
    @JsonProperty("role_name")
    private String roleName;
    private String description;
}
