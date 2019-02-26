package com.realdolmen.backend.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FictionDto.class, name = "Fiction"),
        @JsonSubTypes.Type(value = NonFictionDto.class, name = "Non-fiction"),
        @JsonSubTypes.Type(value = GameDto.class, name = "Game"),
        @JsonSubTypes.Type(value = LpDto.class, name = "Lp")
})
public abstract class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;
    private String type;

    ProductDto(Long id, String title, BigDecimal price, String type) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
    }
}
