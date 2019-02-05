package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.repository.ProductRepository;
import com.realdolmen.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {
    private final ProductRepository productRepository;

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }
}