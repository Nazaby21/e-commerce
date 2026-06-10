package com.school.ecommerce.Service.Impl;

import com.school.ecommerce.Dto.Request.CreateUserRequestDto;
import com.school.ecommerce.Dto.Request.UpdateUserRequestDto;
import com.school.ecommerce.Dto.Response.UserResponseDto;
import com.school.ecommerce.Exception.Custom.ResourceAlreadyExistsException;
import com.school.ecommerce.Exception.Custom.ResourceNotFoundException;
import com.school.ecommerce.Mapper.UserMapper;
import com.school.ecommerce.Model.User;
import com.school.ecommerce.Repository.UserRepository;
import com.school.ecommerce.Repository.UserRoleRepository;
import com.school.ecommerce.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        if (userRepository.existsByEmail(createUserRequestDto.getEmail())) {
            throw ResourceAlreadyExistsException.byField("User", "email", createUserRequestDto.getEmail());
        }

//        UserRole role = userRoleRepository.findById(createUserRequestDto.getRoleId())
//                .orElseThrow(()  -> new ResourceNotFoundException(ErrorMessage.ROLE_NOT_FOUND));
        User user = userMapper.userDtoToEntity(createUserRequestDto);
//        user.setRole(role);
        User savedUser = userRepository.save(user);
        return userMapper.userEntityToDto(savedUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> ResourceNotFoundException.byId("User", id)
        );

        return userMapper.userEntityToDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToDto)
                .toList();
    }

    @Override
    public UserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("User", id));
        userMapper.updateUserFromDto(updateUserRequestDto, user);
        User saveUser = userRepository.save(user);
        return userMapper.userEntityToDto(saveUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.byId("User", id));
        userRepository.delete(user);
    }
}
