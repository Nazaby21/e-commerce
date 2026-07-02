package com.school.ecommerce.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.ReferenceType;

public record AddStockRequestVo(
        @JsonProperty("product_id")
        Long productId,
        Integer quantity,
        @JsonProperty("reference_type")
        ReferenceType referenceType
) {
}
