package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.RoleRequestDto;
import com.school.ecommerce.dto.response.RoleResponseDto;
import com.school.ecommerce.model.UserRole;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    // roleDto to Entity
    @Mapping(target = "id", ignore = true)
    UserRole roleDtoToEntity(RoleRequestDto roleRequestDto);

    // roleEntity toDto
    RoleResponseDto roleEntityToDto(UserRole role);

    // updateRole
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateRoleUserFromDto(RoleRequestDto roleRequestDto, @MappingTarget UserRole userRole);
}
