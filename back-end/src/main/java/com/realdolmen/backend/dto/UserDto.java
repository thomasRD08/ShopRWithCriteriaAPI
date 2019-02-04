package com.realdolmen.backend.dto;

import com.realdolmen.backend.constraint.UniqueUser;
import lombok.*;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the the builder when creating new instances!
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class UserDto {
    @UniqueUser
    private String username;
}
