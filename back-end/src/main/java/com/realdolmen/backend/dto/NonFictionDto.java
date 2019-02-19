package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.NonFictionSubject;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class NonFictionDto extends BookDto{
    private NonFictionSubject nonFictionSubject;

    @Builder

    public NonFictionDto(Long id, String title, Double price, String type, String author, String isbn, String pages, NonFictionSubject nonFictionSubject) {
        super(id, title, price, type, author, isbn, pages);
        this.nonFictionSubject = nonFictionSubject;
    }
}
