package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.FictionDto;

import java.util.List;

public interface FictionFacade {
    FictionDto saveFiction(FictionDto fictionDto);

    FictionDto findFictionById(Long id);

    List<FictionDto> findAllFiction();

    FictionDto updateFiction(FictionDto fictionDto);

    void deleteFiction(Long id);
}
