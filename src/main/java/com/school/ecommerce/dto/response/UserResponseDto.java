package com.school.ecommerce.dto.response;

import com.school.ecommerce.enumeration.Gender;
import com.school.ecommerce.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String username;
    private String email;
    private UserRole role;
    private Gender gender;
}
