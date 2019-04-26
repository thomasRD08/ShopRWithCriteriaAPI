package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameMinAge {
    THREE ("3"),
    SEVEN ("7"),
    TWELVE ("12"),
    SIXTEEN ("16"),
    EIGHTEEN ("18");

    private final String label;
}
