package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateCategoryRequestDto;
import com.school.ecommerce.dto.request.UpdateCategoryRequestDto;
import com.school.ecommerce.dto.response.CategoryResponseDto;
import com.school.ecommerce.model.Category;
import com.school.ecommerce.vo.request.CreateCategoryRequestVo;
import com.school.ecommerce.vo.request.UpdateCategoryRequestVo;
import com.school.ecommerce.vo.response.CategoryResponseVo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // categoryVo to Dto
    CreateCategoryRequestDto createCategoryVoToDto(CreateCategoryRequestVo createCategoryRequestVo);
    UpdateCategoryRequestDto updateCategoryVoToDto(UpdateCategoryRequestVo updateCategoryRequestVo);

    // categoryDto to Entity
    @Mapping(target = "id", ignore = true)
    Category categoryDtoToEntity(CreateCategoryRequestDto createCategoryRequestDto);

    // categoryEntity to Dto
    CategoryResponseDto categoryEntityToDto(Category category);

    //categoryDto to Vo
    CategoryResponseVo categoryDtoToVo(CategoryResponseDto categoryResponseDto);

    //updateCategory
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDto(UpdateCategoryRequestDto updateCategoryRequestDto, @MappingTarget Category category);
}
