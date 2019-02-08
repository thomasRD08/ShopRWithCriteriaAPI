package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.facade.impl.LpFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/lps")
@AllArgsConstructor
public class LpController {
    private final LpFacadeImpl lpFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LpDto createLp(@RequestBody LpDto lpDto) {
        return lpFacade.saveLp(lpDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LpDto getLpById(@PathVariable Long id) {
        return lpFacade.findLpById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LpDto> getAllLps() {
        return lpFacade.findAllLps();
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LpDto updateLp(@PathVariable Long id, @RequestBody LpDto lpDto) {
        if (!id.equals(lpDto.getId())) {
            throw new IllegalArgumentException("Id's don't match");
        }
        return lpFacade.updateLp(lpDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLp(@PathVariable Long id) {
        lpFacade.deleteLp(id);
    }
}
