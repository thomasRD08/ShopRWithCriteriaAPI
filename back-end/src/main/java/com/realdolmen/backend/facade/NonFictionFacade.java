package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.NonFictionDto;

import java.util.List;

public interface NonFictionFacade {
    NonFictionDto saveNonFiction(NonFictionDto nonFictionDto);

    NonFictionDto findNonFictionById(Long id);

    List<NonFictionDto> findAllNonFiction();

    NonFictionDto updateNonFiction(NonFictionDto nonFictionDto);

    void deleteNonFiction(Long id);
}
