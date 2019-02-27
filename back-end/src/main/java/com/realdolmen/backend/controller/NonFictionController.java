package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.NonFictionSubject;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.facade.impl.NonFictionFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/books/non-fiction")
@AllArgsConstructor
public class NonFictionController {
    private final NonFictionFacadeImpl nonFictionFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NonFictionDto createNonFiction(@RequestBody NonFictionDto nonFictionDto) {
        return nonFictionFacade.saveNonFiction(nonFictionDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NonFictionDto getNonFictionById(@PathVariable Long id) {
        return nonFictionFacade.findNonFictionById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NonFictionDto> getAllNonFiction() {
        return nonFictionFacade.findAllNonFiction();
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NonFictionDto updateNonFiction(@PathVariable Long id, @RequestBody NonFictionDto nonFictionDto) {
        if (!id.equals(nonFictionDto.getId())) {
            throw new IllegalArgumentException("Id's don't match");
        }
        return nonFictionFacade.updateNonFiction(nonFictionDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLp(@PathVariable Long id) {
        nonFictionFacade.deleteNonFiction(id);
    }

    @GetMapping(path = "/subjects")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getNonFictionSubjectLabels() {
        return Arrays
                .stream(NonFictionSubject.values())
                .map(NonFictionSubject::getLabel)
                .collect(Collectors.toList());
    }
}
