package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.facade.GameFacade;
import com.realdolmen.backend.mapper.GameMapper;
import com.realdolmen.backend.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GameFacadeImpl implements GameFacade {
    private final GameMapper gameMapper;
    private final GameService gameService;

    @Override
    public Game saveGame(GameDto gameDto) {
        Game game = gameMapper.gameDtoToGame(gameDto);
        return gameService.save(game);
    }

    @Override
    public GameDto findGameById(Long id) {
        Game game = gameService.findById(id);
        return gameMapper.gameToGameDto(game);
    }

    @Override
    public List<GameDto> findAllGames() {
        return gameService.findAll()
                .stream()
                .map(gameMapper::gameToGameDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGame(GameDto gameDto) {
        Game game = gameMapper.gameDtoToGame(gameDto);
        gameService.delete(game);
    }
}
