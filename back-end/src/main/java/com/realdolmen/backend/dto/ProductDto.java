package com.realdolmen.backend.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
    private Double price;
    private String type;
}
