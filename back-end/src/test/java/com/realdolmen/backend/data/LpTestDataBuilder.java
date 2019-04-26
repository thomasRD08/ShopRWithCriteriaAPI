package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;
import com.realdolmen.backend.dto.LpDto;

import java.math.BigDecimal;

public class LpTestDataBuilder {
    public static Lp.LpBuilder buildLpParanoid() {
        return Lp.builder()
                .title("Paranoid")
                .price(new BigDecimal(10.00))
                .type("Lp")
                .artist("Black Sabbath")
                .lpGenre(LpGenre.ROCK);
    }

    public static Lp.LpBuilder buildLpMetallica() {
        return Lp.builder()
                .title("Metallica")
                .price(new BigDecimal(15.00))
                .type("Lp")
                .artist("Metallica")
                .lpGenre(LpGenre.ROCK);
    }

    public static LpDto.LpDtoBuilder buildLpDtoParanoid() {
        return LpDto.builder()
                .title("Paranoid")
                .price(new BigDecimal(10.00))
                .type("Lp")
                .artist("Black Sabbath")
                .lpGenre(LpGenre.ROCK.getLabel());
    }
}