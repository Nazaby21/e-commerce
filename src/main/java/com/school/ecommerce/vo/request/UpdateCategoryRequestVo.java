package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UpdateCategoryRequestVo(
        @JsonProperty("category_name")
        @NotBlank(message = "Category name is require")
        String categoryName,
        String description
) {
}
