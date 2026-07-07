package com.school.ecommerce.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponseDto {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("product_name")
    private String productName;
    private Integer quantity;
    private Double price;
    @JsonProperty("sub_total")
    private Double subTotal;
}
