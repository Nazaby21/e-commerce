package com.school.ecommerce.dto.request;

import com.school.ecommerce.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
    private String username;
    private String email;
    private Gender gender;
}
