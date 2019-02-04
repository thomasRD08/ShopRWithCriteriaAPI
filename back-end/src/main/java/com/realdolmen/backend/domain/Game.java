package com.realdolmen.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Game")
public class Game extends Product {
    private String publisher;

    @Column(name = "min_age")
    private Integer minAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;
}
