package com.school.ecommerce.Exception.Dto;

import com.school.ecommerce.Exception.Enums.ErrorCode;
import lombok.Getter;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ErrorResponse {
    private String message;
    private int status;
    private ErrorCode code;
    private LocalDateTime timestamp;
    private List<String> details;
}
