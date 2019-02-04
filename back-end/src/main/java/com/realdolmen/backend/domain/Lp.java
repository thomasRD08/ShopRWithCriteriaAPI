package com.realdolmen.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Lp")
public class Lp extends Product {
    private String artist;

    @Enumerated(EnumType.STRING)
    @Column(name = "lp_genre")
    private LpGenre lpGenre;
}
