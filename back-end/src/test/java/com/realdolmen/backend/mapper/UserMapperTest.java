package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserKarel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {
    private User user = new User();
    private UserDto userDto = new UserDto();

    @InjectMocks
    private UserMapperImpl userMapper;

    @Before
    public void init() {
        user = buildUserKarel().build();
        userDto.setUsername("Karel");
    }

    @Test
    public void testMapperShouldConvertToDto() {
        UserDto userDto = userMapper.UserToUserDto(user);

        assertEquals(user.getUsername(), userDto.getUsername());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        User user = userMapper.UserDtoToUser(userDto);

        assertEquals(userDto.getUsername(), user.getUsername());
    }

    @Test
    public void testMapperConvertEmptyUserShouldReturnNull() {
        UserDto userDto = userMapper.UserToUserDto(null);

        assertNull(userDto);
    }

    @Test
    public void testMapperConvertEmptyUserDtoShouldReturnNull() {
        User user = userMapper.UserDtoToUser(null);

        assertNull(user);
    }
}