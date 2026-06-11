package com.school.ecommerce.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequestDto {
    String categoryName;
    String description;
}
