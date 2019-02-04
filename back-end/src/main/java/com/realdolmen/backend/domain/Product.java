package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name = "type")
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product extends BaseEntity {
    private String title;

    private Double price;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;
}


