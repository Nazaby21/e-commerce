package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.AddStockRequestDto;
import com.school.ecommerce.dto.response.ApiResponse;
import com.school.ecommerce.dto.response.StockResponseDto;
import com.school.ecommerce.service.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping
    public ApiResponse<StockResponseDto> addStock(@Valid @RequestBody AddStockRequestDto addStockRequestDto) {
        StockResponseDto stockResponseDto = stockService.addStock(addStockRequestDto);
        return ApiResponse.success(stockResponseDto);
    }

    @GetMapping
    public ApiResponse<List<StockResponseDto>> getAllStocks() {
        List<StockResponseDto> allStocks = stockService.getAllStocks();
        return ApiResponse.success(allStocks);
    }
}
