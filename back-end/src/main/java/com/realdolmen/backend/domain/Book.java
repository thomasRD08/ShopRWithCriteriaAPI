package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
abstract class Book extends Product {
    @NotBlank(message = "Author cannot be blank")
    @Size(max = 50, message = "Author should not be greater than 50 characters")
    @Column(name = "author")
    private String author;

    @NotBlank(message = "ISBN cannot be blank")
    @ISBN(message = "ISBN is not valid")
    @Column(name = "isbn")
    private String isbn;

    @NotBlank(message = "Pages cannot be blank")
    @Pattern(regexp = "^[0-9]{1,99999}$", message = "Pages should consist of numbers and should be between 1 and 99999")
    @Column(name = "pages")
    private String pages;

    Book(@NotBlank(message = "Title cannot be blank") @Size(max = 50, message = "Title should not be greater than 50 characters") String title,
                @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.01", message = "Price should not be less than 0.01") @DecimalMax(value = "9999.99", message = "Price should not be greater than 9999.99") BigDecimal price,
                String type,
                @NotBlank(message = "Author cannot be blank") @Size(max = 50, message = "Author should not be greater than 50 characters") String author,
                @NotBlank(message = "ISBN cannot be blank") @ISBN(message = "ISBN is not valid") String isbn,
                @NotBlank(message = "Pages cannot be blank") @Pattern(regexp = "^[0-9]{1,99999}$", message = "Pages should consist of numbers and should be between 1 and 99999") String pages) {
        super(title, price, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
