package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequestDto {
    @JsonProperty("category_name")
    String categoryName;
    String description;
}
