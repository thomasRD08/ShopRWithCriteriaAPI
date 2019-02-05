package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;
import com.realdolmen.backend.dto.LpDto;

public class LpTestDataBuilder {
    public static Lp.LpBuilder buildLpParanoid() {
        return Lp.builder()
                .title("Paranoid")
                .price(10D)
                .type("Lp")
                .artist("Black Sabbath")
                .lpGenre(LpGenre.ROCK);
    }

    public static Lp.LpBuilder buildLpMetallica() {
        return Lp.builder()
                .title("Metallica")
                .price(15D)
                .type("Lp")
                .artist("Metallica")
                .lpGenre(LpGenre.ROCK);
    }

    public static LpDto.LpDtoBuilder buildLpDtoParanoid() {
        return LpDto.builder()
                .title("Paranoid")
                .price(10D)
                .type("Lp")
                .artist("Black Sabbath")
                .lpGenre(LpGenre.ROCK);
    }
}