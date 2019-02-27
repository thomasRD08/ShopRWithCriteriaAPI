package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.GameGenre;
import com.realdolmen.backend.domain.GameMinAge;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.facade.impl.GameFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/games")
@AllArgsConstructor
public class GameController {
    private final GameFacadeImpl gameFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameDto createGame(@RequestBody GameDto gameDto) {
        return gameFacade.saveGame(gameDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameDto getGameById(@PathVariable Long id) {
        return gameFacade.findGameById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameDto> getAllGames() {
        return gameFacade.findAllGames();
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameDto updateGame(@PathVariable Long id, @RequestBody GameDto gameDto) {
        if (!id.equals(gameDto.getId())) {
            throw new IllegalArgumentException("Id's don't match");
        }
        return gameFacade.updateGame(gameDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@PathVariable Long id) {
        gameFacade.deleteGame(id);
    }

    @GetMapping(path = "/genres")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getGameGenreLabels() {
        return Arrays
                .stream(GameGenre.values())
                .map(GameGenre::getLabel)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/min-ages")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getGameMinAgeLabels() {
        return Arrays
                .stream(GameMinAge.values())
                .map(GameMinAge::getLabel)
                .collect(Collectors.toList());
    }
}
