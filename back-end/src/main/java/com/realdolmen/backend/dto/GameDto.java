package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;
import lombok.*;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class GameDto {
    private String publisher;

    private Integer minAge;

    private GameGenre gameGenre;
}
