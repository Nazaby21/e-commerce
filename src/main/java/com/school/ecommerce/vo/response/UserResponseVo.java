package com.school.ecommerce.vo.response;

import com.school.ecommerce.enumeration.Gender;

public record UserResponseVo(
        String username,
        String email,
        String roleName,
        Gender gender
) {
}
