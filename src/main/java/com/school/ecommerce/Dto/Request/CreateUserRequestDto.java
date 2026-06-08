package com.school.ecommerce.Dto.Request;

import com.school.ecommerce.Enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    private String username;
    private String email;
    private String password;
    private Long roleId;
    private Gender gender;
}
