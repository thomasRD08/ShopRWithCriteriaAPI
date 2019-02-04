package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Lp")
@AllArgsConstructor
@NoArgsConstructor
public class Lp extends Product {
    private String artist;

    @Enumerated(EnumType.STRING)
    @Column(name = "lp_genre")
    private LpGenre lpGenre;
}
