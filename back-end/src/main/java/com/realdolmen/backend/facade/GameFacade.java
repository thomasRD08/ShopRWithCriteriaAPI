package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.GameDto;

import java.util.List;

public interface GameFacade {
    GameDto saveGame(GameDto gameDto);

    GameDto findGameById(Long id);

    List<GameDto> findAllGames();

    GameDto updateGame(GameDto gameDto);

    void deleteGame(Long id);
}
