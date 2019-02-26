package com.realdolmen.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class GameDto extends ProductDto {
    private String publisher;
    private String gameMinAge;
    private String gameGenre;

    @Builder
    public GameDto(Long id, String title, BigDecimal price, String type, String publisher, String gameMinAge, String gameGenre) {
        super(id, title, price, type);
        this.publisher = publisher;
        this.gameMinAge = gameMinAge;
        this.gameGenre = gameGenre;
    }
}
