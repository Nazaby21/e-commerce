package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDto {
    @JsonProperty("role_name")
    @NotBlank(message = "Role name is require")
    private String roleName;

    private String description;
}
