package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;

import java.util.List;

public interface GameFacade {
    Game saveGame(GameDto gameDto);

    GameDto findGameById(Long id);

    List<GameDto> findAllGames();

    void deleteGame(GameDto gameDto);
}
