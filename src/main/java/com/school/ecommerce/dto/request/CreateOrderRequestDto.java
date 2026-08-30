package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequestDto {
    @NotNull(message = "buyer_id is required.")
    @JsonProperty("buyer_id")
    private Long buyerId;

    @NotEmpty(message = "Order must contain at least one item.")
    @Valid
    private List<CreateOrderItemRequestDto> items;
}
