package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void testShouldFindAllProducts() {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Lp());
        expectedProducts.add(new Game());

        when(productRepository.findAll()).thenReturn(expectedProducts);

        List<Product> foundProducts = productService.findAll();

        verify(productRepository, times(1)).findAll();
        assertEquals(2, foundProducts.size());
    }
}
