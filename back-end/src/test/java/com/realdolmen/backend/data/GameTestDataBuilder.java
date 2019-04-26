package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.GameGenre;
import com.realdolmen.backend.domain.GameMinAge;
import com.realdolmen.backend.dto.GameDto;

import java.math.BigDecimal;

public class GameTestDataBuilder {
    public static Game.GameBuilder buildGameArtifact() {
        return Game.builder()
                .title("Artifact")
                .price(new BigDecimal(19.00))
                .type("Game")
                .publisher("Valve")
                .gameMinAge(GameMinAge.SIXTEEN)
                .gameGenre(GameGenre.RTS);
    }

    public static Game.GameBuilder buildGameMinecraft() {
        return Game.builder()
                .title("Minecraft")
                .price(new BigDecimal(20.00))
                .type("Game")
                .publisher("Mojang")
                .gameMinAge(GameMinAge.THREE)
                .gameGenre(GameGenre.SANDBOX);
    }

    public static GameDto.GameDtoBuilder buildGameDtoArtifact() {
        return GameDto.builder()
                .title("Artifact")
                .price(new BigDecimal(19.00))
                .type("Game")
                .publisher("Valve")
                .gameMinAge(GameMinAge.SIXTEEN.getLabel())
                .gameGenre(GameGenre.RTS.getLabel());
    }
}
