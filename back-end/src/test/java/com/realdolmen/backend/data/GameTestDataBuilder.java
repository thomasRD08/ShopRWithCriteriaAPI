package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.GameGenre;
import com.realdolmen.backend.dto.GameDto;

public class GameTestDataBuilder {
    public static Game.GameBuilder buildGameArtifact() {
        return Game.builder()
                .title("Artifact")
                .price(19D)
                .type("Game")
                .publisher("Valve")
                .minAge(12)
                .gameGenre(GameGenre.RTS);
    }

    public static Game.GameBuilder buildGameMinecraft() {
        return Game.builder()
                .title("Minecraft")
                .price(20D)
                .type("Game")
                .publisher("Mojang")
                .minAge(6)
                .gameGenre(GameGenre.SANDBOX);
    }

    public static GameDto.GameDtoBuilder buildGameDtoArtifact() {
        return GameDto.builder()
                .title("Artifact")
                .price(19D)
                .type("Game")
                .publisher("Valve")
                .minAge(12)
                .gameGenre(GameGenre.RTS);
    }
}
