package com.school.ecommerce.exception.Dto;

import lombok.Getter;
import lombok.Builder;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private Integer status;
    private LocalDateTime timestamp;
}
