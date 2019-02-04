package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FictionGenre {
    THRILLER ("Thriller"),
    FANTASY ("Fantasy"),
    DETECTIVE ("Detective"),
    ROMANCE ("Romance"),
    SCIFI ("Sci-Fi");

    private final String label;
}
