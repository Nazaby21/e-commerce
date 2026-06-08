package com.school.ecommerce.Controller;

import com.school.ecommerce.Dto.Request.RoleRequestDto;
import com.school.ecommerce.Dto.Response.RoleResponseDto;
import com.school.ecommerce.Mapper.UserRoleMapper;
import com.school.ecommerce.Service.UserRoleService;
import com.school.ecommerce.Vo.Request.RoleRequestVo;
import com.school.ecommerce.Vo.Response.RoleResponseVo;
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
