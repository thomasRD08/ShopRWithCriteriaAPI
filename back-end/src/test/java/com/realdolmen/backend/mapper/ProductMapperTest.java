package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpParanoid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductMapperTest {
    @InjectMocks
    private ProductMapperImpl productMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        Product product = buildLpParanoid().build();

        ProductDto testProductDto = productMapper.productToProductDto(product);

        assertEquals(product.getTitle(), testProductDto.getTitle());
        assertEquals(product.getPrice(), testProductDto.getPrice());
        assertEquals(product.getType(), testProductDto.getType());
    }

    @Test
    public void testMapperConvertEmptyProductShouldReturnNull() {
        ProductDto testProductDto = productMapper.productToProductDto(null);

        assertNull(testProductDto);
    }
}
