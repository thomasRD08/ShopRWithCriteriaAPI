package com.realdolmen.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Entity
@DiscriminatorValue("Game")
@Getter
@Setter
@NoArgsConstructor
public class Game extends Product {
    private String publisher;
    @Column(name = "min_age")
    private Integer minAge;
    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;

    @Builder
    public Game(String title, Double price, String type, String publisher, Integer minAge, GameGenre gameGenre) {
        super(title, price, type);
        this.publisher = publisher;
        this.minAge = minAge;
        this.gameGenre = gameGenre;
    }
}
