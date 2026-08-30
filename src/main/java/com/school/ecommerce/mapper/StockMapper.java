package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.AddStockRequestDto;
import com.school.ecommerce.dto.response.StockResponseDto;
import com.school.ecommerce.model.Product;
import com.school.ecommerce.model.StockBalance;
import com.school.ecommerce.model.StockTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {

    // DTO -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stockType", ignore = true)
    @Mapping(target = "transactionDate", ignore = true)
    @Mapping(target = "product", source = "product")
    StockTransaction toEntity(AddStockRequestDto addStockRequestDto, Product product);

    // Entity -> DTO
    @Mapping(source = "product.id", target = "productId")
    StockResponseDto stockEntityToDto(StockBalance stockBalance);
}
