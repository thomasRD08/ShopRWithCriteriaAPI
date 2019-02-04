package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDto gameToGameDto(Game game);

    Game gameDtoToGame(GameDto gameDto);
}
