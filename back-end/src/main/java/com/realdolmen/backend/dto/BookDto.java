package com.realdolmen.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;

    private String title;

    private Double price;

    private String type;

    private String author;

    private String isbn;

    private String pages;
}
