package com.school.ecommerce.dto.request;

import com.school.ecommerce.model.Order;
import com.school.ecommerce.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderItemRequestDto {
    private Order orderId;
    private Product productId;

}
