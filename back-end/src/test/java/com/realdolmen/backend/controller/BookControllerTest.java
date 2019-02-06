package com.realdolmen.backend.controller;

import com.realdolmen.backend.advice.GlobalExceptionHandler;
import com.realdolmen.backend.facade.impl.BookFacadeImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @InjectMocks
    private BookController bookController;
    @Mock
    private BookFacadeImpl bookFacade;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setControllerAdvice(GlobalExceptionHandler.class)
                .build();
    }

    @Test
    public void testShouldGetAllBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}