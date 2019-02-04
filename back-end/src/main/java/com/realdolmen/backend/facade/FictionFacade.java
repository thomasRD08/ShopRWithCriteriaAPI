package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;

import java.util.List;

public interface FictionFacade {
    Fiction saveFiction(FictionDto fictionDto);

    FictionDto findFictionById(Long id);

    List<FictionDto> findAllFiction();

    void deleteFiction(FictionDto fictionDto);
}
