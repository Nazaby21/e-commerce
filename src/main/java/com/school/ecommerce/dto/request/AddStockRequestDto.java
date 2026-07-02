package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.enumeration.ReferenceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStockRequestDto {
    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
    @JsonProperty("reference_type")
    private ReferenceType referenceType;
}
