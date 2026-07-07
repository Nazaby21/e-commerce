package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateProductRequestDto;
import com.school.ecommerce.dto.request.UpdateProductRequestDto;
import com.school.ecommerce.dto.response.ProductResponseDto;
import com.school.ecommerce.model.Product;
import com.school.ecommerce.vo.request.CreateProductRequestVo;
import com.school.ecommerce.vo.request.UpdateProductRequestVo;
import com.school.ecommerce.vo.response.ProductResponseVo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // productVo to Dto
    CreateProductRequestDto createdProductVoToDto(CreateProductRequestVo createProductRequestVo);
    UpdateProductRequestDto updatedProductVoToDto(UpdateProductRequestVo updateProductRequestVo);

    // productDto to Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(target = "stockTransactions", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    Product productDtoToEntity(CreateProductRequestDto createProductRequestDto);

    // productEntity to Dto
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "stockBalance.quantity", target = "quantity")
    ProductResponseDto productEntityToDto(Product product);

    // productDto to Vo
    ProductResponseVo productDtoToVo(ProductResponseDto productResponseDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", ignore = true)
    @Mapping(target = "category.id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "stockTransactions", ignore = true)
    @Mapping(target = "orderItems", ignore = true)
    void updateProductFromDto(UpdateProductRequestDto updateProductRequestDto, @MappingTarget Product product);
}
