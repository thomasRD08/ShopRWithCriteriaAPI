package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.FictionGenre;
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
public class FictionDto extends BookDto {
    private FictionGenre fictionGenre;
    private String summary;

    @Builder
    public FictionDto(Long id, String title, Double price, String type, String author, String isbn, String pages, FictionGenre fictionGenre, String summary) {
        super(id, title, price, type, author, isbn, pages);
        this.fictionGenre = fictionGenre;
        this.summary = summary;
    }
}
