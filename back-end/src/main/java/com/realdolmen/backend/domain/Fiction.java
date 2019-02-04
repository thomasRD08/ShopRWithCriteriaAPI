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
@DiscriminatorValue("Fiction")
@Getter
@Setter
@NoArgsConstructor
public class Fiction extends Book {
    @Enumerated(EnumType.STRING)
    @Column(name = "fiction_genre")
    private FictionGenre fictionGenre;

    private String summary;

    @Builder
    public Fiction(String title, Double price, String type, String author, String isbn, String pages, FictionGenre fictionGenre, String summary) {
        super(title, price, type, author, isbn, pages);
        this.fictionGenre = fictionGenre;
        this.summary = summary;
    }
}
