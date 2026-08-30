package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequestDto {
    @JsonProperty("category_name")
    @NotBlank(message = "categoryname is required")
    private String categoryName;

    private String description;
}
