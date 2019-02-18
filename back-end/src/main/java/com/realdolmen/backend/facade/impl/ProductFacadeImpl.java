package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.dto.ProductDto;
import com.realdolmen.backend.facade.ProductFacade;
import com.realdolmen.backend.mapper.ProductMapper;
import com.realdolmen.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductFacadeImpl implements ProductFacade {
    private final ProductMapper productMapper;
    private final ProductService productService;

    @Override
    public ProductDto findProductById(final Long id) {
        Product product = productService.findById(id);
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productService.findAll()
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }
}
