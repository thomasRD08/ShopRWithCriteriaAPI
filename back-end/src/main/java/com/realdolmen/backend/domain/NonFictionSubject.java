package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NonFictionSubject {
    HISTORY ("History"),
    COOKBOOK ("Cookery Book"),
    SCIENCE ("Science"),
    SPORTS ("Sports");

    private final String label;
}
