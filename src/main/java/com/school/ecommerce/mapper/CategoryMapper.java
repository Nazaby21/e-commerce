package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.dto.request.UpdateCategoryRequestDto;
import com.school.ecommerce.dto.response.CategoryResponseDto;
import com.school.ecommerce.model.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // categoryDto to Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "categoryName", target = "name")
    @Mapping(target = "products", ignore = true)
    Category categoryDtoToEntity(CreateCategoryRequestDto createCategoryRequestDto);

    // categoryEntity to Dto
    @Mapping(source = "name", target = "categoryName")
    CategoryResponseDto categoryEntityToDto(Category category);

    // updateCategory
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "categoryName", target = "name")
    @Mapping(target = "products", ignore = true)
    void updateCategoryFromDto(UpdateCategoryRequestDto updateCategoryRequestDto, @MappingTarget Category category);
}
