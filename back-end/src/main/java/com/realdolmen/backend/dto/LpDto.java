package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.LpGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LpDto {
    private String artist;

    private LpGenre lpGenre;
}
