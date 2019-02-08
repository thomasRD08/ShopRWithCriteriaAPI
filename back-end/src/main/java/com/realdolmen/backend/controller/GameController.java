package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.facade.impl.GameFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
