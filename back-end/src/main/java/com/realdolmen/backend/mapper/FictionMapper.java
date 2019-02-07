package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FictionMapper {
    FictionDto fictionToFictionDto(Fiction fiction);

    Fiction fictionDtoToFiction(FictionDto fictionDto);

    void fictionDtoToFiction(FictionDto fictionDto, @MappingTarget Fiction fiction);
}
