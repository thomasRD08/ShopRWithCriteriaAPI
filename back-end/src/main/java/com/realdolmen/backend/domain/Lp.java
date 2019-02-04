package com.realdolmen.backend.domain;

import lombok.*;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class Lp extends Product {
    private String artist;

    @Enumerated(EnumType.STRING)
    @Column(name = "lp_genre")
    private LpGenre lpGenre;
}
