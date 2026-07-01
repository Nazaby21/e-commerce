package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequestVo(
        @JsonProperty("category_name")
        @NotBlank(message = "categoryname is required")
        String categoryName,
        String description
) {
}
