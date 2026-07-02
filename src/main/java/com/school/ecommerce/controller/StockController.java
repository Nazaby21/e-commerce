package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.AddStockRequestDto;
import com.school.ecommerce.dto.response.StockResponseDto;
import com.school.ecommerce.mapper.StockMapper;
import com.school.ecommerce.service.StockService;
import com.school.ecommerce.vo.request.AddStockRequestVo;
import com.school.ecommerce.vo.response.StockResponseVo;
import lombok.RequiredArgsConstructor;
import com.school.ecommerce.exception.Dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockMapper stockMapper;
    private final StockService stockService;

    @PostMapping()
    public ApiResponse<StockResponseVo> addStock(@RequestBody AddStockRequestVo addStockRequestVo) {
        AddStockRequestDto addStockRequestDto = stockMapper.addStockVoToDto(addStockRequestVo);
        StockResponseDto stockResponseDto = stockService.addStock(addStockRequestDto);
        StockResponseVo stockResponseVo = stockMapper.stockDtoToVo(stockResponseDto);
        return ApiResponse.success(stockResponseVo);
    }

    @GetMapping()
    public ApiResponse<List<StockResponseVo>> getAllStocks() {
        List<StockResponseVo> allStocks = stockService.getAllStocks()
                .stream()
                .map(stockMapper::stockDtoToVo)
                .toList();
        return ApiResponse.success(allStocks);
    }
}
