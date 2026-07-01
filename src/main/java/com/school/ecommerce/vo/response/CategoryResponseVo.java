package com.school.ecommerce.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoryResponseVo(
        @JsonProperty("category_name")
        String categoryName,
        String description
) {
}
