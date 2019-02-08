package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.facade.impl.FictionFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/books/fiction")
@AllArgsConstructor
public class FictionController {
    private final FictionFacadeImpl fictionFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FictionDto createFiction(@RequestBody FictionDto fictionDto) {
        return fictionFacade.saveFiction(fictionDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FictionDto getFictionById(@PathVariable Long id) {
        return fictionFacade.findFictionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FictionDto> getAllFiction() {
        return fictionFacade.findAllFiction();
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FictionDto updateFiction(@PathVariable Long id, @RequestBody FictionDto fictionDto) {
        if (!id.equals(fictionDto.getId())) {
            throw new IllegalArgumentException("Id's don't match");
        }
        return fictionFacade.updateFiction(fictionDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFiction(@PathVariable Long id) {
        fictionFacade.deleteFiction(id);
    }
}
