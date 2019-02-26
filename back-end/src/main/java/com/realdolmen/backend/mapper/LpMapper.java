package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;
import com.realdolmen.backend.dto.LpDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LpMapper {
    @Mapping(source = "lpGenre.label", target = "lpGenre")
    LpDto lpToLpDto(Lp lp);

    @Mapping(source = "lpDto", target = "lpGenre", qualifiedByName = "formLpGenre")
    Lp lpDtoToLp(LpDto lpDto);

    @Mapping(source = "lpDto", target = "lpGenre", qualifiedByName = "formLpGenre")
    void lpDtoToLp(LpDto lpDto, @MappingTarget Lp lp);

    @Named("formLpGenre")
    default LpGenre formLpGenre(LpDto lpDto) {
        LpGenre lpGenre = null;

        for (LpGenre value : LpGenre.values()) {
            if (value.getLabel().equals(lpDto.getLpGenre())) {
                lpGenre = value;
            }
        }
        return lpGenre;
    }
}
