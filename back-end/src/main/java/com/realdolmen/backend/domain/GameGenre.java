package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameGenre {
    MMORPG ("MMORPG"),
    RPG ("RPG"),
    FPS ("FPS"),
    RTS ("RTS"),
    SANDBOX ("Sandbox"),
    MOBA ("MOBA");

    private final String label;
}
