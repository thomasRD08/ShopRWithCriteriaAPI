package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}