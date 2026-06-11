package com.school.ecommerce.Mapper;

import com.school.ecommerce.Dto.Request.CreateProductRequestDto;
import com.school.ecommerce.Dto.Request.UpdateProductRequestDto;
import com.school.ecommerce.Dto.Response.ProductResponseDto;
import com.school.ecommerce.Model.Product;
import com.school.ecommerce.Vo.Request.CreateProductRequestVo;
import com.school.ecommerce.Vo.Request.UpdateProductRequestVo;
import com.school.ecommerce.Vo.Response.ProductResponseVo;
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
    Product productDtoToEntity(CreateProductRequestDto createProductRequestDto);

    // productEntity to Dto
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "category.id", target = "categoryId")
    ProductResponseDto productEntityToDto(Product product);

    // productDto to Vo
    ProductResponseVo productDtoToVo(ProductResponseDto productResponseDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", ignore = true)
    @Mapping(target = "category.id", ignore = true)
    @Mapping(target = "status", ignore = true)
    void updateProductFromDto(UpdateProductRequestDto updateProductRequestDto, @MappingTarget Product product);
}
