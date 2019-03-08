package com.realdolmen.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Entity
@Table(name = "game")
@DiscriminatorValue("Game")
@Getter
@Setter
@NoArgsConstructor
public class Game extends Product {
    @NotBlank(message = "Publisher cannot be blank")
    @Size(max = 50, message = "Publisher should not be greater than 50 characters")
    @Column(name = "publisher")
    private String publisher;

    @NotNull(message = "Minimum age cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "min_age")
    private GameMinAge gameMinAge;

    @NotNull(message = "Game genre cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;

    @Builder
    public Game(@NotBlank(message = "Title cannot be blank") @Size(max = 50, message = "Title should not be greater than 50 characters") String title,
                @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.01", message = "Price should not be less than 0.01") @DecimalMax(value = "9999.99", message = "Price should not be greater than 9999.99") BigDecimal price,
                String type,
                @NotBlank(message = "Publisher cannot be blank") @Size(max = 50, message = "Publisher should not be greater than 50 characters") String publisher,
                @NotNull(message = "Minimum age cannot be null") GameMinAge gameMinAge,
                @NotNull(message = "Game genre cannot be null") GameGenre gameGenre) {
        super(title, price, type);
        this.publisher = publisher;
        this.gameMinAge = gameMinAge;
        this.gameGenre = gameGenre;
    }
}