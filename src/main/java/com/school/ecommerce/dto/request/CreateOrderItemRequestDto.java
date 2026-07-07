package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.ecommerce.model.Order;
import com.school.ecommerce.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderItemRequestDto {
    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
}
