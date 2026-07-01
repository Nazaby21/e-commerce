package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    private String username;
    private String email;
    private String password;
    @JsonProperty("role_id")
    private Long roleId;
    private Gender gender;
}
