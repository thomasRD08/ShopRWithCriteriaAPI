package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.GameTestDataBuilder.buildGameArtifact;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

//TODO: Fix tests
@RunWith(MockitoJUnitRunner.class)
public class GameFacadeImplTest {
    @InjectMocks
    private GameFacadeImpl gameFacade;
    @Mock
    private GameService gameService;

    @Test
    public void testShouldMockFacade() {
        assertThat(gameFacade).isNotNull();
    }

//    @Test
//    public void testShouldSaveGame() {
//        GameDto gameDto = buildGameDtoArtifact().build();
//
//        Game game = gameFacade.saveGame(gameDto);
//
//        verify(gameService, times(1)).save(game);
//    }

    @Test
    public void testShouldFindGameById() {
        Game game = buildGameArtifact().build();
        Long id = game.getId();

        gameFacade.findGameById(id);

        verify(gameService, times(1)).findById(id);
    }

    @Test
    public void testShouldFindAllGames() {
        gameFacade.findAllGames();

        verify(gameService, times(1)).findAll();
    }

//    @Test
//    public void testShouldDeleteGame() {
//        GameDto gameDto = buildGameDtoArtifact().build();
//        Game game = gameMapper.gameDtoToGame(gameDto);
//
//        gameFacade.deleteGame(gameDto);
//
//        verify(gameService, times(1)).delete(game);
//    }
}