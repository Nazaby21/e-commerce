package com.school.ecommerce.Dto.Request;

import com.school.ecommerce.Model.Order;
import com.school.ecommerce.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderItemRequestDto {
    private Order orderId;
    private Product productId;

}
