package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.ProductDto;
import com.realdolmen.backend.facade.impl.ProductFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductFacadeImpl productFacade;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productFacade.findAllProducts();
    }
}
