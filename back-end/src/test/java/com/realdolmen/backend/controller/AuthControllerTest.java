package com.realdolmen.backend.controller;

import com.google.gson.Gson;
import com.realdolmen.backend.advice.GlobalExceptionHandler;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.impl.UserFacadeImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserDtoKarel;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {
    @InjectMocks
    private AuthController authController;
    @Mock
    private UserFacadeImpl userFacade;
    private MockMvc mockMvc;
    private Gson gson;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController)
                .setControllerAdvice(GlobalExceptionHandler.class)
                .build();
        gson = new Gson();
    }

    @Test
    public void testShouldPerformPostAndReturnStatusIsOkAndReturnContentAndInvokeFacadeFindByUsername() throws Exception {
        UserDto expectedUserDto = buildUserDtoKarel().build();
        String username = expectedUserDto.getUsername();
        String content = gson.toJson(expectedUserDto);

        when(userFacade.findUserByUsername(username)).thenReturn(expectedUserDto);

        mockMvc.perform(post("/login").content(content).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(content));

        verify(userFacade, times(1)).findUserByUsername(username);
    }
}