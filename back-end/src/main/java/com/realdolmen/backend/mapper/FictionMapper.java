package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.domain.FictionGenre;
import com.realdolmen.backend.dto.FictionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface FictionMapper {
    @Mapping(source = "fictionGenre.label", target = "fictionGenre")
    FictionDto fictionToFictionDto(Fiction fiction);

    @Mapping(source = "fictionDto", target = "fictionGenre", qualifiedByName = "formFictionGenre")
    Fiction fictionDtoToFiction(FictionDto fictionDto);

    @Mapping(source = "fictionDto", target = "fictionGenre", qualifiedByName = "formFictionGenre")
    void fictionDtoToFiction(FictionDto fictionDto, @MappingTarget Fiction fiction);

    @Named("formFictionGenre")
    default FictionGenre formFictionGenre(FictionDto fictionDto) {
        FictionGenre fictionGenre = null;

        for (FictionGenre value : FictionGenre.values()) {
            if (value.getLabel().equals(fictionDto.getFictionGenre())) {
                fictionGenre = value;
            }
        }
        return fictionGenre;
    }
}
