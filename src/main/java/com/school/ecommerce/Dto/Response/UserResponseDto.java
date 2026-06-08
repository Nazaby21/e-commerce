package com.school.ecommerce.Dto.Response;

import com.school.ecommerce.Enumeration.Gender;
import com.school.ecommerce.Model.UserRole;
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
