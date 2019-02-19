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
@DiscriminatorValue("Non-fiction")
@Getter
@Setter
@NoArgsConstructor
public class NonFiction extends Book {
    @Enumerated(EnumType.STRING)
    @Column(name = "nonfiction_subject")
    private NonFictionSubject nonFictionSubject;

    @Builder
    public NonFiction(Long id, Long version, String title, Double price, String type, String author, String isbn, String pages, NonFictionSubject nonFictionSubject) {
        super(id, version, title, price, type, author, isbn, pages);
        this.nonFictionSubject = nonFictionSubject;
    }
}
