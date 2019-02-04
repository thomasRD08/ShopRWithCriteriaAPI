package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;

import java.util.List;

public interface NonFictionFacade {
    NonFiction saveNonFiction(NonFictionDto nonFictionDto);

    NonFictionDto findNonFictionById(Long id);

    List<NonFictionDto> findAllNonFiction();

    void deleteNonFiction(NonFictionDto nonFictionDto);
}
