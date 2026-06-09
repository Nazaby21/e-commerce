package com.school.ecommerce.Mapper;

import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Request.UpdateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;
import com.school.ecommerce.Model.User;
import com.school.ecommerce.Vo.Request.CreateUserRequestVo;
import com.school.ecommerce.Vo.Request.UpdateUserRequestVo;
import com.school.ecommerce.Vo.Response.UserResponseVo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // userVo to userDto
    CreateUserRequestDto createdUserVoToDto(CreateUserRequestVo createUserRequestVo);
    UpdateUserRequestDto updateUserVoToDto(UpdateUserRequestVo updateUserRequestVo);

    // userDto to Entity
    @Mapping(target = "id",  ignore = true)
//    @Mapping(source = "roleId", target = "role.id")
    User userDtoToEntity(CreateUserRequestDto createUserRequestDto);

    // userDto to userVo
    @Mapping(target = "roleName", ignore = true)
    UserResponseVo userDtoToVo(UserResponseDto userResponseDto);

    // userEntity to userDto
//    @Mapping(source = "role.roleName", target = "roleName")
    @Mapping(target = "role", ignore = true)
    UserResponseDto userEntityToDto(User user);

    // updateUser
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "role", ignore = true)
    void updateUserFromDto(UpdateUserRequestDto updateUserRequestDto, @MappingTarget User user);
}
