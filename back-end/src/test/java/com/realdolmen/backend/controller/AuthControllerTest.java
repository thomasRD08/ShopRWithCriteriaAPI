package com.realdolmen.backend.controller;

import com.google.gson.Gson;
import com.realdolmen.backend.advice.GlobalExceptionHandler;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacadeImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {
    @Mock
    private UserFacadeImpl userFacade;

    @InjectMocks
    private AuthController authController;
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
    public void testShouldLogInUser() throws Exception {
        String expectedUsername = "Karel";
        UserDto userDto = new UserDto(expectedUsername);
        String content = gson.toJson(userDto);

        when(userFacade.findUserByUsername(expectedUsername)).thenReturn(userDto);

        mockMvc.perform(post("/login").content(content).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(content));

        verify(userFacade, times(1)).findUserByUsername(expectedUsername);
    }

    //TODO: Convert to TestRestTemplate test
    /*@Test
    public void testShouldRegisterUser() throws Exception {
        User user = new User("Karel");
        UserDto userDto = new UserDto("Karel");
        String content = gson.toJson(user);

        when(authController.registerUser(userDto)).thenReturn(user);

        mockMvc.perform(post("/register").content(content).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(content));
    }*/
}