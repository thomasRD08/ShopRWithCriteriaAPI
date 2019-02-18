package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.ProductDto;

import java.util.List;

public interface ProductFacade {
    ProductDto findProductById(Long id);

    List<ProductDto> findAllProducts();
}
