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
@Table(name = "non_fiction")
@DiscriminatorValue("Non-fiction")
@Getter
@Setter
@NoArgsConstructor
public class NonFiction extends Book {
    @NotNull(message = "Non-fiction subject cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "nonfiction_subject")
    private NonFictionSubject nonFictionSubject;

    @Builder
    public NonFiction(@NotBlank(message = "Title cannot be blank") @Size(max = 50, message = "Title should not be greater than 50 characters") String title,
                      @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.00", message = "Price should not be less than 0.00") @DecimalMax(value = "1000.00", message = "Price should not be greater than 1000.00") BigDecimal price,
                      String type, @NotBlank(message = "Author cannot be blank") @Size(max = 50, message = "Author should not be greater than 50 characters") String author,
                      @NotBlank(message = "ISBN cannot be blank") @ISBN(message = "ISBN is not valid") String isbn,
                      @NotBlank(message = "Pages cannot be blank") @Pattern(regexp = "^[0-9]{1,15000}$", message = "Pages should consist of numbers and should be between 1 and 15000") String pages,
                      @NotNull(message = "Non-fiction subject cannot be null") NonFictionSubject nonFictionSubject) {
        super(title, price, type, author, isbn, pages);
        this.nonFictionSubject = nonFictionSubject;
    }
}
