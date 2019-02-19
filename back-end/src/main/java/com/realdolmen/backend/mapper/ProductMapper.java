package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    default ProductDto productToProductDto(Product product) {
        return null; //todo delete
    }
}