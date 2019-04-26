package com.realdolmen.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Entity
@Table(name = "lp")
@DiscriminatorValue("Lp")
@Getter
@Setter
@NoArgsConstructor
public class Lp extends Product {
    @NotBlank(message = "Artist cannot be blank")
    @Size(max = 50, message = "Artist should not be greater than 50 characters")
    @Column(name = "artist")
    private String artist;

    @NotNull(message = "Lp genre cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "lp_genre")
    private LpGenre lpGenre;

    @Builder
    public Lp(@NotBlank(message = "Title cannot be blank") @Size(max = 50, message = "Title should not be greater than 50 characters") String title,
              @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.01", message = "Price should not be less than 0.01") @DecimalMax(value = "9999.99", message = "Price should not be greater than 9999.99") BigDecimal price,
              String type,
              @NotBlank(message = "Artist cannot be blank") @Size(max = 50, message = "Artist should not be greater than 50 characters") String artist,
              @NotNull(message = "Lp genre cannot be null") LpGenre lpGenre) {
        super(title, price, type);
        this.artist = artist;
        this.lpGenre = lpGenre;
    }
}
