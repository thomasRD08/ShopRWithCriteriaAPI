package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class GameDto {
    private String title;

    private Double price;

    private String type;

    private String publisher;

    private Integer minAge;

    private GameGenre gameGenre;

    @Builder
    public GameDto(String title, Double price, String type, String publisher, Integer minAge, GameGenre gameGenre) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.publisher = publisher;
        this.minAge = minAge;
        this.gameGenre = gameGenre;
    }
}
