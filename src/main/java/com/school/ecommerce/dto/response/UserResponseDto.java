package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import com.school.ecommerce.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    Long id;
    private String username;
    private String email;
    @JsonProperty("role_name")
    private String roleName;
    private Gender gender;
}
