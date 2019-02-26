package com.realdolmen.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
abstract class BookDto extends ProductDto {
    private String author;
    private String isbn;
    private String pages;

    BookDto(Long id, String title, BigDecimal price, String type, String author, String isbn, String pages) {
        super(id, title, price, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
