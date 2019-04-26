package com.realdolmen.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class FictionDto extends BookDto {
    private String fictionGenre;
    private String summary;

    @Builder
    public FictionDto(Long id, String title, BigDecimal price, String type, String author, String isbn, String pages, String fictionGenre, String summary) {
        super(id, title, price, type, author, isbn, pages);
        this.fictionGenre = fictionGenre;
        this.summary = summary;
    }
}
