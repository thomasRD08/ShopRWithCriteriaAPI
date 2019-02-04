package com.realdolmen.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name = "type")
public abstract class Product extends BaseEntity {
    private String title;

    private Double price;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;
}


