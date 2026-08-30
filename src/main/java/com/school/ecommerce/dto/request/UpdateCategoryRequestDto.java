package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequestDto {
    @JsonProperty("category_name")
    @NotBlank(message = "Category name is require")
    private String categoryName;

    private String description;
}
