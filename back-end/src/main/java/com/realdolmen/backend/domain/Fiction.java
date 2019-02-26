package com.realdolmen.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Entity
@Table(name = "fiction")
@DiscriminatorValue("Fiction")
@Getter
@Setter
@NoArgsConstructor
public class Fiction extends Book {
    @NotNull(message = "Fiction genre cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "fiction_genre")
    private FictionGenre fictionGenre;

    @NotBlank(message = "Summary cannot be blank")
    @Size(min = 20, max = 500, message = "Summary should be between 20 and 500 characters")
    @Column(name = "summary")
    private String summary;

    @Builder
    public Fiction(@NotBlank(message = "Title cannot be blank") @Size(max = 50, message = "Title should not be greater than 50 characters") String title,
                   @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.00", message = "Price should not be less than 0.00") @DecimalMax(value = "1000.00", message = "Price should not be greater than 1000.00") BigDecimal price,
                   String type,
                   @NotBlank(message = "Author cannot be blank") @Size(max = 50, message = "Author should not be greater than 50 characters") String author,
                   @NotBlank(message = "ISBN cannot be blank") @ISBN(message = "ISBN is not valid") String isbn,
                   @NotBlank(message = "Pages cannot be blank") @Pattern(regexp = "^[0-9]{1,15000}$", message = "Pages should consist of numbers and should be between 1 and 15000") String pages,
                   @NotNull(message = "Fiction genre cannot be null") FictionGenre fictionGenre,
                   @NotBlank(message = "Summary cannot be blank") @Size(min = 20, max = 500, message = "Summary should be between 20 and 500 characters") String summary) {
        super(title, price, type, author, isbn, pages);
        this.fictionGenre = fictionGenre;
        this.summary = summary;
    }
}
