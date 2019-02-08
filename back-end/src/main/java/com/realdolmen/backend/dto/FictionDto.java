package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.FictionGenre;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class FictionDto {
    private Long id;
    private String title;
    private Double price;
    private String type;
    private String author;
    @ISBN
    private String isbn;
    private String pages;
    private FictionGenre fictionGenre;
    private String summary;

    @Builder
    public FictionDto(String title, Double price, String type, String author, @ISBN String isbn, String pages, FictionGenre fictionGenre, String summary) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.fictionGenre = fictionGenre;
        this.summary = summary;
    }
}
