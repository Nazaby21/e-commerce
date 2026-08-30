package com.school.ecommerce.exception.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.ecommerce.exception.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private LocalDateTime timestamp;
    private Integer status;
    private String code;
    private String message;
    private String path;
    private List<ValidationError> errors;
}
