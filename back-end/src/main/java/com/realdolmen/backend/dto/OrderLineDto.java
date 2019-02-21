package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderLineDto {
    private Long id;
    private Integer amount;
    private Product product;
}
