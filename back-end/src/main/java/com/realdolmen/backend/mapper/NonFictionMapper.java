package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NonFictionMapper {
    NonFictionDto nonFictionToNonFictionDto(NonFiction nonFiction);

    NonFiction nonFictionDtoToNonFiction(NonFictionDto nonFictionDto);

    void nonFictionDtoToNonFiction(NonFictionDto nonFictionDto, @MappingTarget NonFiction nonFiction);
}