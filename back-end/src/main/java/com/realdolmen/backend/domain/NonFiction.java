package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Entity
@DiscriminatorValue("Non-fiction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class NonFiction extends Book {
    @Enumerated(EnumType.STRING)
    @Column(name = "nonfiction_subject")
    private NonFictionSubject nonFictionSubject;
}
