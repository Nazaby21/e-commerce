package com.school.ecommerce.Dto.Request;

import com.school.ecommerce.Enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequestDto {
    private Double totalPrice;
    private Status status;

}
