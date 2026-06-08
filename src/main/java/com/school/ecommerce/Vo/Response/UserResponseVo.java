package com.school.ecommerce.Vo.Response;

import com.school.ecommerce.Enumeration.Gender;

public record UserResponseVo(
        String username,
        String email,
        String roleName,
        Gender gender
) {
}
