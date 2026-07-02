package com.school.ecommerce.service;

import com.school.ecommerce.dto.request.AddStockRequestDto;
import com.school.ecommerce.dto.response.StockResponseDto;

import java.util.List;

public interface StockService {
    StockResponseDto addStock(AddStockRequestDto addStockRequestDto);
    List<StockResponseDto> getAllStocks();
}
