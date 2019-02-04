package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.ProductDto;
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
    public List<ProductDto> findAllProducts() {
        return productService.findAll()
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }
}
