package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class Book extends Product {
    private String author;

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d{1}")
    private String isbn;

    private String pages;
}
