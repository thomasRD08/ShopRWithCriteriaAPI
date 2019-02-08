package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Book extends Product {
    private String author;
    private String isbn;
    private String pages;

    public Book(String title, Double price, String type, String author, String isbn, String pages) {
        super(title, price, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
