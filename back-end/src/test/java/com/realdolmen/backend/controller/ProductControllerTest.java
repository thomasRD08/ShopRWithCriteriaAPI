package com.realdolmen.backend.controller;

import com.realdolmen.backend.advice.GlobalExceptionHandler;
import com.realdolmen.backend.facade.impl.ProductFacadeImpl;
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
public class ProductControllerTest {
    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductFacadeImpl productFacade;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setControllerAdvice(GlobalExceptionHandler.class)
                .build();
    }

    @Test
    public void testShouldGetAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}