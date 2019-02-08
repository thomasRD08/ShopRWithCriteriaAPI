package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.backend.data.GameTestDataBuilder.buildGameArtifact;
import static com.realdolmen.backend.data.GameTestDataBuilder.buildGameMinecraft;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceImplTest {
    @InjectMocks
    private GameServiceImpl gameService;
    @Mock
    private GameRepository gameRepository;

    @Test
    public void testShouldSaveGame() {
        Game expectedGame = buildGameArtifact().build();

        when(gameRepository.save(any())).thenReturn(expectedGame);

        Game savedGame = gameService.save(expectedGame);

        verify(gameRepository, times(1)).save(expectedGame);
        assertEquals(expectedGame, savedGame);
    }

    @Test
    public void testShouldFindGameById() {
        Game expectedGame = buildGameArtifact().build();

        when(gameRepository.save(any())).thenReturn(expectedGame);
        when(gameRepository.findById(any())).thenReturn(Optional.of(expectedGame));

        Long id = gameService.save(expectedGame).getId();
        Game foundGame = gameService.findById(id);

        verify(gameRepository, times(1)).save(expectedGame);
        verify(gameRepository, times(1)).findById(id);
        assertEquals(expectedGame, foundGame);
    }

    @Test
    public void testShouldFindAllGames() {
        List<Game> expectedGames = new ArrayList<>();
        expectedGames.add(buildGameArtifact().build());
        expectedGames.add(buildGameMinecraft().build());

        when(gameRepository.findAll()).thenReturn(expectedGames);

        List<Game> foundGames = gameService.findAll();

        verify(gameRepository, times(1)).findAll();
        assertEquals(2, foundGames.size());
    }

    //    TODO: Edit test
    @Test
    public void delete() {
        Game game = buildGameArtifact().build();

        gameService.delete(game);

        verify(gameRepository, times(1)).delete(game);
    }
}