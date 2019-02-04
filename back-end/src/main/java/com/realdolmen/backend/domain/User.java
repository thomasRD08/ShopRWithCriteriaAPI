package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.Entity;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the the builder when creating new instances!
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class User extends BaseEntity {
    private String username;
}