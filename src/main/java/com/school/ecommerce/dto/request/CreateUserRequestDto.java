package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    @NotBlank(message = "Please input your name")
    private String username;

    @NotBlank(message = "Please input your email")
    private String email;

    @NotBlank(message = "Please input your password")
    private String password;

    @Positive(message = "Id must be bigger than 0")
    @JsonProperty("role_id")
    private Long roleId;

    private Gender gender;
}
