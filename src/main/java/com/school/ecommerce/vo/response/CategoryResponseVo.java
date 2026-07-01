package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryResponseVo(
        Long id,
        @JsonProperty("category_name")
        String categoryName,
        String description
) {
}
