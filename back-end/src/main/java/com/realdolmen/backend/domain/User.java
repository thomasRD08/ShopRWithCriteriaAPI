package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class User extends BaseEntity {
    private String username;
}