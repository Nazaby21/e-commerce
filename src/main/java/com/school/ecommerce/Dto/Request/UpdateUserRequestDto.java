package com.school.ecommerce.Dto.Request;

import com.school.ecommerce.Enumeration.Gender;
import com.school.ecommerce.Model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
    private String username;
    private String email;
    private Gender gender;
}
