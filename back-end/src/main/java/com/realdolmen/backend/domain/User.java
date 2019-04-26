package com.realdolmen.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Version
    @Column(name = "version")
    protected Long version;

    @NotBlank(message = "Username cannot be blank")
    @Size(max = 30, message = "Username should not be greater than 30 characters")
    @Column(name = "username")
    private String username;

    @Builder
    public User(@NotBlank(message = "Username cannot be blank") @Max(value = 30, message = "Username should not be greater than 30 characters") String username) {
        this.username = username;
    }
    public String getUsername()
    {
        return this.username;
    }
}