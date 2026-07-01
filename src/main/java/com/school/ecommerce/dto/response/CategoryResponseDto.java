package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto {
    @JsonProperty("category_name")
    String categoryName;
    String description;
}
