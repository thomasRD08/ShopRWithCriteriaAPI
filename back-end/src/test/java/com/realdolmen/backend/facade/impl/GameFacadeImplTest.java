package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.mapper.GameMapper;
import com.realdolmen.backend.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class GameFacadeImplTest {
    @InjectMocks
    private GameFacadeImpl gameFacade;
    @Mock
    private GameService gameService;
    @Mock
    private GameMapper gameMapper;

    @Test
    public void testShouldMockFacade() {
        assertThat(gameFacade).isNotNull();
    }

    @Test
    public void testShouldInvokeServiceSave() {
        GameDto gameDto = new GameDto();

        gameFacade.saveGame(gameDto);

        verify(gameService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceFindById() {
        Long id = 1L;

        gameFacade.findGameById(id);

        verify(gameService, times(1)).findById(id);
    }

    @Test
    public void testShouldInvokeServiceFindAll() {
        gameFacade.findAllGames();

        verify(gameService, times(1)).findAll();
    }

    @Test
    public void testShouldInvokeServiceSaveByUpdate() {
        GameDto gameDto = new GameDto();

        gameFacade.updateGame(gameDto);

        verify(gameService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceDeleteAndArgumentAndReturnMatch() {
        Long id = 1L;
        Game game = new Game();
        when(gameService.findById(id)).thenReturn(game);
        gameFacade.deleteGame(id);

        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameService, times(1)).delete(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isSameAs(game);
    }
}