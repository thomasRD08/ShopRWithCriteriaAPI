package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Fiction")
@AllArgsConstructor
@NoArgsConstructor
public class Fiction extends Book {
    @Enumerated(EnumType.STRING)
    @Column(name = "fiction_genre")
    private FictionGenre fictionGenre;

    private String summary;
}
