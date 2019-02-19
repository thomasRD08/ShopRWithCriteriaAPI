package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BookDto extends ProductDto {
    private String author;
    private String isbn;
    private String pages;

    public BookDto(Long id, String title, Double price, String type, String author, String isbn, String pages) {
        super(id, title, price, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
