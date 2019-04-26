package com.realdolmen.backend.dto;

import com.realdolmen.backend.constraint.UniqueUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    @UniqueUser
    private String username;

    @Builder
    public UserDto(String username) {
        this.username = username;
    }
}
