package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.GameGenre;
import com.realdolmen.backend.domain.GameMinAge;
import com.realdolmen.backend.dto.GameDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GameMapper {
    @Mappings({
            @Mapping(source = "gameGenre.label", target = "gameGenre"),
            @Mapping(source = "gameMinAge.label", target = "gameMinAge")
    })
    GameDto gameToGameDto(Game game);

    @Mappings({
            @Mapping(source = "gameDto", target = "gameGenre", qualifiedByName = "formGameGenre"),
            @Mapping(source = "gameDto", target = "gameMinAge", qualifiedByName = "formGameMinAge")
    })
    Game gameDtoToGame(GameDto gameDto);

    @Mappings({
            @Mapping(source = "gameDto", target = "gameGenre", qualifiedByName = "formGameGenre"),
            @Mapping(source = "gameDto", target = "gameMinAge", qualifiedByName = "formGameMinAge")
    })
    void gameDtoToGame(GameDto gameDto, @MappingTarget Game game);

    @Named("formGameGenre")
    default GameGenre formGameGenre(GameDto gameDto) {
        GameGenre gameGenre = null;

        for (GameGenre value : GameGenre.values()) {
            if (value.getLabel().equals(gameDto.getGameGenre())) {
                gameGenre = value;
            }
        }
        return gameGenre;
    }

    @Named("formGameMinAge")
    default GameMinAge formGameMinAge(GameDto gameDto) {
        GameMinAge gameMinAge = null;

        for (GameMinAge value : GameMinAge.values()) {
            if (value.getLabel().equals(gameDto.getGameMinAge())) {
                gameMinAge = value;
            }
        }
        return gameMinAge;
    }
}
