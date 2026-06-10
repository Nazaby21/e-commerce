package com.school.ecommerce.Vo.Request;

import jakarta.validation.constraints.NotBlank;

public record UpdateCategoryRequestVo(
        @NotBlank(message = "Category name is require")
        String categoryName,
        String description
) {
}
