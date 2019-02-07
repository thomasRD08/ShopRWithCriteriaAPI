package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductFacadeImplTest {
    @InjectMocks
    private ProductFacadeImpl productFacade;
    @Mock
    private ProductService productService;

    @Test
    public void testShouldMockFacade() {
        assertThat(productFacade).isNotNull();
    }

    @Test
    public void testShouldFindAllProducts() {
        productFacade.findAllProducts();

        verify(productService, times(1)).findAll();
    }
}
