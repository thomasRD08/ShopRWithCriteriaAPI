package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapperImpl;
import com.realdolmen.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserKarel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTest {
    @Mock
    private UserMapperImpl userMapper;
    @Mock
    private UserService userService;
    @InjectMocks
    private UserFacade userFacade;

    @Test
    public void testShouldMockFacade() {
        assertThat(userFacade).isNotNull();
    }

    @Test
    public void testShouldSaveUser() {
        UserDto userDto = new UserDto();

        User user = userFacade.saveUser(userDto);

        verify(userService, times(1)).save(user);
    }

    @Test
    public void testShouldFindUserByUsername() {
        String username = buildUserKarel().build().getUsername();

        userFacade.findUserByUsername(username);

        verify(userService, times(1)).findByUsername(username);
    }

    @Test
    public void testShouldFindAllUsers() {
        userFacade.findAllUsers();

        verify(userService, times(1)).findAll();
    }
}
