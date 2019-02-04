package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Game")
@AllArgsConstructor
@NoArgsConstructor
public class Game extends Product {
    private String publisher;

    @Column(name = "min_age")
    private Integer minAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;
}
