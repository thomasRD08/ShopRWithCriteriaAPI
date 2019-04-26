package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;

import java.util.List;

public interface UserFacade {
    User saveUser(UserDto userDto);

    UserDto findUserByUsername(String username);

    List<UserDto> findAllUsers();
}
