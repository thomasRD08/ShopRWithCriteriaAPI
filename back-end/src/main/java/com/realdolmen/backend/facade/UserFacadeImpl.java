package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    public User saveUser(UserDto userDto) {
        User user = userMapper.UserDtoToUser(userDto);
        return userService.save(user);
    }

    @Override
    public UserDto findUserByUsername(String username) {
        User user = userService.findByUsername(username);
        return userMapper.UserToUserDto(user);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userService.findAll()
                .stream()
                .map(userMapper::UserToUserDto)
                .collect(Collectors.toList());
    }
}