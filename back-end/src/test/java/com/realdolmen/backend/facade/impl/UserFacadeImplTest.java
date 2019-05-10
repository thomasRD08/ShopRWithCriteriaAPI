package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserFacadeImplTest {
    @InjectMocks
    private UserFacadeImpl userFacade;
    @Mock
    private UserService userService;
    @Mock
    private UserMapper userMapper;

    @Test
    public void testShouldMockFacade() {
        assertThat(userFacade).isNotNull();
    }

    @Test
    public void testShouldInvokeServiceSave() {
        UserDto userDto = new UserDto();

        userFacade.saveUser(userDto);

        verify(userService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceFindByUsername() {
        String username = "Test";

        userFacade.findUserByUsername(username);

        verify(userService, times(1)).findByUsername(username);
    }

    @Test
    public void testShouldInvokeServiceFindAll() {
        userFacade.findAllUsers();

        verify(userService, times(1)).findAll();
    }
}
