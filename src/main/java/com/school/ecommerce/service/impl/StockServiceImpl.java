package com.school.ecommerce.service.impl;

import com.school.ecommerce.dto.request.AddStockRequestDto;
import com.school.ecommerce.dto.response.StockResponseDto;
import com.school.ecommerce.enumeration.StockType;
import com.school.ecommerce.exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.mapper.StockMapper;
import com.school.ecommerce.model.Product;
import com.school.ecommerce.model.StockBalance;
import com.school.ecommerce.model.StockTransaction;
import com.school.ecommerce.repository.ProductRepository;
import com.school.ecommerce.repository.StockBalanceRepository;
import com.school.ecommerce.repository.StockTransactionRepository;
import com.school.ecommerce.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class StockServiceImpl implements StockService {
    private final StockBalanceRepository stockBalanceRepository;
    private final StockTransactionRepository stockTransactionRepository;
    private final ProductRepository productRepository;
    private final StockMapper stockMapper;

    @Override
    public StockResponseDto addStock(AddStockRequestDto addStockRequestDto) {
        Product product = productRepository.findById(addStockRequestDto.getProductId())
                .orElseThrow(() -> ResourceNotFoundException.byId("Product", addStockRequestDto.getProductId()));

        StockTransaction stockTransaction = stockMapper.toEntity(addStockRequestDto, product);

        stockTransaction.setStockType(StockType.IN_STOCK);

        stockTransactionRepository.save(stockTransaction);

        StockBalance stockBalance = stockBalanceRepository
                .findByProductId(product.getId())
                .orElseThrow(() -> ResourceNotFoundException.byId("StockBalance", addStockRequestDto.getProductId()));

        stockBalance.setQuantity(stockBalance.getQuantity() + addStockRequestDto.getQuantity());
        StockBalance save = stockBalanceRepository.save(stockBalance);
        return stockMapper.stockEntityToDto(save);
    }

    @Override
    public List<StockResponseDto> getAllStocks() {
        return stockBalanceRepository.findAll()
                .stream()
                .map(stockMapper::stockEntityToDto)
                .toList();
    }
}
