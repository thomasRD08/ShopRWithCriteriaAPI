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
    public GameDto saveGame(final GameDto gameDto) {
        return save(gameDto, new Game());
    }

    @Override
    public GameDto findGameById(final Long id) {
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
    public GameDto updateGame(final GameDto gameDto) {
        Game game = gameService.findById(gameDto.getId());
        return save(gameDto, game);
    }

    @Override
    public void deleteGame(final Long id) {
        Game game = gameService.findById(id);
        gameService.delete(game);
    }

    private GameDto save(GameDto gameDto, Game game) {
        gameMapper.gameDtoToGame(gameDto, game);
        game = gameService.save(game);
        return gameMapper.gameToGameDto(game);
    }
}
