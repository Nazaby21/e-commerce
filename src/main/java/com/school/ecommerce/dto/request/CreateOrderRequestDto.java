package com.school.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequestDto {
    @JsonProperty("buyer_id")
    private Long BuyerId;
    private List<CreateOrderItemRequestDto> items;
}
