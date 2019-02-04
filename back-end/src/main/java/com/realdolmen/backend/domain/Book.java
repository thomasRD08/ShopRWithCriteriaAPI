package com.realdolmen.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Book extends Product {
    private String author;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d{1}")
    private String isbn;

    private String pages;
}
