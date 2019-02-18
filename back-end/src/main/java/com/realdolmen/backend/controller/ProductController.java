package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.ProductDto;
import com.realdolmen.backend.facade.impl.ProductFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductFacadeImpl productFacade;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProductById(@PathVariable Long id) {
        return productFacade.findProductById(id);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productFacade.findAllProducts();
    }
}
