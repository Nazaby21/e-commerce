package com.school.ecommerce.mapper;

import com.school.ecommerce.dto.request.CreateUserRequestDto;
import com.school.ecommerce.dto.request.UpdateUserRequestDto;
import com.school.ecommerce.dto.response.UserResponseDto;
import com.school.ecommerce.model.User;
import com.school.ecommerce.vo.request.CreateUserRequestVo;
import com.school.ecommerce.vo.request.UpdateUserRequestVo;
import com.school.ecommerce.vo.response.UserResponseVo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // userVo to userDto
    CreateUserRequestDto createdUserVoToDto(CreateUserRequestVo createUserRequestVo);
    UpdateUserRequestDto updateUserVoToDto(UpdateUserRequestVo updateUserRequestVo);

    // userDto to Entity
    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "products", ignore = true)
    User userDtoToEntity(CreateUserRequestDto createUserRequestDto);

    // userDto to userVo
    UserResponseVo userDtoToVo(UserResponseDto userResponseDto);

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
