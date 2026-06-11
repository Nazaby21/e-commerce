package com.school.ecommerce.Vo.Request;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequestVo(
        @NotBlank(message = "categoryname is required")
        String categoryName,
        String description
) {
}
