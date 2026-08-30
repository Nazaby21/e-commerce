package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateUserRequestDto;
import com.school.ecommerce.dto.request.UpdateUserRequestDto;
import com.school.ecommerce.dto.response.UserResponseDto;
import com.school.ecommerce.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // userDto to Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "products", ignore = true)
    User userDtoToEntity(CreateUserRequestDto createUserRequestDto);

    // userEntity to userDto
    @Mapping(source = "role.roleName", target = "roleName")
    UserResponseDto userEntityToDto(User user);

    // updateUser
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateUserFromDto(UpdateUserRequestDto updateUserRequestDto, @MappingTarget User user);
}
