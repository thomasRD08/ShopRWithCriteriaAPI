package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserDtoKarel;
import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserKarel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {
    @InjectMocks
    private UserMapperImpl userMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        User user = buildUserKarel().build();

        UserDto testUserDto = userMapper.userToUserDto(user);

        assertEquals(user.getUsername(), testUserDto.getUsername());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        UserDto userDto = buildUserDtoKarel().build();

        User testUser = userMapper.userDtoToUser(userDto);

        assertEquals(userDto.getUsername(), testUser.getUsername());
    }

    @Test
    public void testMapperConvertEmptyUserShouldReturnNull() {
        UserDto testUserDto = userMapper.userToUserDto(null);

        assertNull(testUserDto);
    }

    @Test
    public void testMapperConvertEmptyUserDtoShouldReturnNull() {
        User testUser = userMapper.userDtoToUser(null);

        assertNull(testUser);
    }
}