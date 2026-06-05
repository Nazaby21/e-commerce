package com.school.ecommerce.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequestDto {
    @NotBlank(message = "Category name is require")
    String categoryName;
    String categoryDescription;
}
