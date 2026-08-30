package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderItemRequestDto {
    @NotNull(message = "product is required.")
    @JsonProperty("product_id")
    private Long productId;

    @NotNull(message = "QTY is required.")
    @Min(value = 1, message = "QTY must be greater than 0.")
    private Integer quantity;
}
