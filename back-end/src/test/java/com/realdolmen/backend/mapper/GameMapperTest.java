package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.GameTestDataBuilder.buildGameArtifact;
import static com.realdolmen.backend.data.GameTestDataBuilder.buildGameDtoArtifact;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class GameMapperTest {
    @InjectMocks
    private GameMapperImpl gameMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        Game game = buildGameArtifact().build();

        GameDto testGameDto = gameMapper.gameToGameDto(game);

        assertEquals(game.getTitle(), testGameDto.getTitle());
        assertEquals(game.getPrice(), testGameDto.getPrice());
        assertEquals(game.getType(), testGameDto.getType());
        assertEquals(game.getPublisher(), testGameDto.getPublisher());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        GameDto gameDto = buildGameDtoArtifact().build();

        Game testGame = gameMapper.gameDtoToGame(gameDto);

        assertEquals(gameDto.getTitle(), testGame.getTitle());
        assertEquals(gameDto.getPrice(), testGame.getPrice());
        assertEquals(gameDto.getType(), testGame.getType());
        assertEquals(gameDto.getPublisher(), testGame.getPublisher());
    }

    @Test
    public void testMapperConvertEmptyGameShouldReturnNull() {
        GameDto testGameDto = gameMapper.gameToGameDto(null);

        assertNull(testGameDto);
    }

    @Test
    public void testMapperConvertEmptyGameDtoShouldReturnNull() {
        Game testGame = gameMapper.gameDtoToGame(null);

        assertNull(testGame);
    }
}
