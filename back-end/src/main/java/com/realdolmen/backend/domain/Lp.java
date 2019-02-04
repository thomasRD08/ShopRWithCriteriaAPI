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
@DiscriminatorValue("Lp")
@Getter
@Setter
@NoArgsConstructor
public class Lp extends Product {
    private String artist;

    @Enumerated(EnumType.STRING)
    @Column(name = "lp_genre")
    private LpGenre lpGenre;

    @Builder
    public Lp(String title, Double price, String type, String artist, LpGenre lpGenre) {
        super(title, price, type);
        this.artist = artist;
        this.lpGenre = lpGenre;
    }
}
