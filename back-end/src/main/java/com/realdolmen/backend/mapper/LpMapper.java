package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LpMapper {
    LpDto lpToLpDto(Lp lp);

    Lp lpDtoToLp(LpDto lpDto);

    void lpDtoToLp(LpDto lpDto, @MappingTarget Lp lp);
}
