package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {
    @InjectMocks
    private UserMapperImpl userMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        User user = new User("Karel");
        UserDto testUserDto = userMapper.UserToUserDto(user);

        assertEquals(user.getUsername(), testUserDto.getUsername());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        UserDto userDto = new UserDto("Karel");
        User testUser = userMapper.UserDtoToUser(userDto);

        assertEquals(userDto.getUsername(), testUser.getUsername());
    }

    @Test
    public void testMapperConvertEmptyUserShouldReturnNull() {
        UserDto testUserDto = userMapper.UserToUserDto(null);

        assertNull(testUserDto);
    }

    @Test
    public void testMapperConvertEmptyUserDtoShouldReturnNull() {
        User testUser = userMapper.UserDtoToUser(null);

        assertNull(testUser);
    }
}