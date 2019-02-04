package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product extends BaseEntity {
    private String title;

    private Double price;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;
}


