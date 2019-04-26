package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.LpDto;

import java.util.List;

public interface LpFacade {
    LpDto saveLp(LpDto lpDto);

    LpDto findLpById(Long id);

    List<LpDto> findAllLps();

    LpDto updateLp(LpDto lpDto);

    void deleteLp(Long id);
}