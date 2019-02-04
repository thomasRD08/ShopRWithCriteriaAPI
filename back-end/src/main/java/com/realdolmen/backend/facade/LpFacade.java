package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;

import java.util.List;

public interface LpFacade {
    Lp saveLp(LpDto lpDto);

    LpDto findLpById(Long id);

    List<LpDto> findAllLps();

    void deleteLp(LpDto lpDto);
}
