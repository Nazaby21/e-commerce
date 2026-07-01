package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
    private String username;
    private String email;
    @JsonProperty("role_id")
    private Long roleId;
    private Gender gender;
}
