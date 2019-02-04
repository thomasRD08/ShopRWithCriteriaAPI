package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.FictionGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FictionDto {
    private FictionGenre fictionGenre;

    private String summary;
}
