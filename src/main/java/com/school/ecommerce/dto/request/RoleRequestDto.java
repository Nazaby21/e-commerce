package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDto {
    @JsonProperty("role_name")
    private String roleName;
    private String description;
}
