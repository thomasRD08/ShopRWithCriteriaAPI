package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Version
    @Column(name = "version")
    protected Long version;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 50, message = "Title should not be greater than 50 characters")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.00", message = "Price should not be less than 0.00")
    @DecimalMax(value = "1000.00", message = "Price should not be greater than 1000.00")
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    Product(@NotBlank(message = "Title cannot be blank") @Size(max = 50, message = "Title should not be greater than 50 characters") String title,
            @NotNull(message = "Price cannot be null") @DecimalMin(value = "0.00", message = "Price should not be less than 0.00") @DecimalMax(value = "1000.00", message = "Price should not be greater than 1000.00") BigDecimal price,
            String type) {
        this.title = title;
        this.price = price;
        this.type = type;
    }
}


