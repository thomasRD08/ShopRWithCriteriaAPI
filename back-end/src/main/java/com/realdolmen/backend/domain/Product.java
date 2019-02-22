package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Version
    protected Long version;
    private String title;
    private Double price;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    public Product(Long id, Long version, String title, Double price, String type) {
        this.id = id;
        this.version = version;
        this.title = title;
        this.price = price;
        this.type = type;
    }
}


