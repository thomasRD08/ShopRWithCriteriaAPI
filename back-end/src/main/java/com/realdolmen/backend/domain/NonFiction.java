package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Non-fiction")
@AllArgsConstructor
@NoArgsConstructor
public class NonFiction extends Book {
    @Enumerated(EnumType.STRING)
    @Column(name = "nonfiction_subject")
    private NonFictionSubject nonFictionSubject;
}
