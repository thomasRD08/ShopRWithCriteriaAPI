package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderLineDto {
    private Long id;
    private Integer amount;
//    TODO: Change to ProductDto
    private ProductDto product;
}
