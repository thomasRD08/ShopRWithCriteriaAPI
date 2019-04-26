package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.domain.NonFictionSubject;
import com.realdolmen.backend.dto.NonFictionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface NonFictionMapper {
    @Mapping(source = "nonFictionSubject.label", target = "nonFictionSubject")
    NonFictionDto nonFictionToNonFictionDto(NonFiction nonFiction);

    @Mapping(source = "nonFictionDto", target = "nonFictionSubject", qualifiedByName = "formNonFictionSubject")
    NonFiction nonFictionDtoToNonFiction(NonFictionDto nonFictionDto);

    @Mapping(source = "nonFictionDto", target = "nonFictionSubject", qualifiedByName = "formNonFictionSubject")
    void nonFictionDtoToNonFiction(NonFictionDto nonFictionDto, @MappingTarget NonFiction nonFiction);

    @Named("formNonFictionSubject")
    default NonFictionSubject formNonFictionSubject(NonFictionDto nonFictionDto) {
        NonFictionSubject nonFictionSubject = null;

        for (NonFictionSubject value : NonFictionSubject.values()) {
            if (value.getLabel().equals(nonFictionDto.getNonFictionSubject())) {
                nonFictionSubject = value;
            }
        }
        return nonFictionSubject;
    }
}