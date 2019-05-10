package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_line")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount should not be less than 1")
    @Max(value = 100, message = "Amount should not be greater than 100")
    private Integer amount;

    @NotNull(message = "Product cannot be null")
    @OneToOne
    private Product product;

    public OrderLine(@NotNull(message = "Amount cannot be null") @Min(value = 1, message = "Amount should not be less than 1") @Max(value = 100, message = "Amount should not be greater than 100") Integer amount, @NotNull(message = "Product cannot be null") Product product) {
        this.amount = amount;
        this.product = product;
    }
}