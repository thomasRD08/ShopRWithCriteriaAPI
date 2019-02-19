package com.realdolmen.backend.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Fiction.class, name = "Fiction"),
        @JsonSubTypes.Type(value = NonFiction.class, name = "Non-fiction"),
        @JsonSubTypes.Type(value = Game.class, name = "Game"),
        @JsonSubTypes.Type(value = Lp.class, name = "Lp")
})
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


