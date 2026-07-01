package com.school.ecommerce.controller;

import com.school.ecommerce.dto.request.RoleRequestDto;
import com.school.ecommerce.dto.response.RoleResponseDto;
import com.school.ecommerce.mapper.UserRoleMapper;
import com.school.ecommerce.service.UserRoleService;
import com.school.ecommerce.vo.request.RoleRequestVo;
import com.school.ecommerce.vo.response.RoleResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/role")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;
    private final UserRoleMapper userRoleMapper;

    @PostMapping
    public RoleResponseVo createRole(@RequestBody RoleRequestVo roleRequestVo) {
        RoleRequestDto roleRequestDto = userRoleMapper.roleVoToDto(roleRequestVo);
        RoleResponseDto roleResponseDto = userRoleService.createRole(roleRequestDto);
        return userRoleMapper.roleDtoToVo(roleResponseDto);
    }
}
