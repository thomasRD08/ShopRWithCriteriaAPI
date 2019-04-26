package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LpGenre {
    CLASSICAL("Classical"),
    POP("Pop"),
    ROCK("Rock"),
    ELECTRONIC("Electronic"),
    JAZZ("Jazz"),
    HIPHOP("Hip Hop");

    private final String label;
}