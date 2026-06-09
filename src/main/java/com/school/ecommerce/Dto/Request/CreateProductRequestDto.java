package com.school.ecommerce.Dto.Request;

import com.school.ecommerce.Enumeration.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String productName;
    private String description;
    private Double productPrice;
    private Status status;
}
