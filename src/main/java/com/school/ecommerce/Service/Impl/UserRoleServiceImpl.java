package com.school.ecommerce.Service.Impl;

import com.school.ecommerce.Dto.Request.RoleRequestDto;
import com.school.ecommerce.Dto.Response.RoleResponseDto;
import com.school.ecommerce.Exception.Constants.ErrorMessage;
import com.school.ecommerce.Exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.Mapper.UserMapper;
import com.school.ecommerce.Mapper.UserRoleMapper;
import com.school.ecommerce.Model.UserRole;
import com.school.ecommerce.Repository.UserRoleRepository;
import com.school.ecommerce.Service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;
    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        if (userRoleRepository.existsByRoleName(roleRequestDto.getRoleName())) {
            throw new ResourceNotFoundException(ErrorMessage.ROLE_ALREADY_EXISTS);
        }
        UserRole userRole = userRoleMapper.roleDtoToEntity(roleRequestDto);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return userRoleMapper.roleEntityToDto(savedUserRole);
    }

    @Override
    public RoleResponseDto getRoleById(Long id) {
        return null;
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return List.of();
    }

    @Override
    public RoleResponseDto updateRole(Long id, RoleRequestDto roleRequestDto) {
        return null;
    }
}
