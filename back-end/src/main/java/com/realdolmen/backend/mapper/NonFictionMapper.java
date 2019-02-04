package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NonFictionMapper {
    NonFictionDto nonFictionToNonFictionDto(NonFiction nonFiction);

    NonFiction nonFictionDtoToNonFiction(NonFictionDto nonFictionDto);
}