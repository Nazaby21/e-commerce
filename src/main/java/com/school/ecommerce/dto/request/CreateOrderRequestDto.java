package com.school.ecommerce.dto.request;

import com.school.ecommerce.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequestDto {
    private Double totalPrice;
    private Status status;

}
