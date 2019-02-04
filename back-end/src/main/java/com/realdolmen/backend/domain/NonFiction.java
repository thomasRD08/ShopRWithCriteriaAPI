package com.realdolmen.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Non-fiction")
public class NonFiction extends Book {
    @Enumerated(EnumType.STRING)
    @Column(name = "nonfiction_subject")
    private NonFictionSubject nonFictionSubject;
}
