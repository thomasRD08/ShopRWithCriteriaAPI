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
public class LpDto extends ProductDto {
    private String artist;
    private String lpGenre;

    @Builder
    public LpDto(Long id, String title, BigDecimal price, String type, String artist, String lpGenre) {
        super(id, title, price, type);
        this.artist = artist;
        this.lpGenre = lpGenre;
    }
}
