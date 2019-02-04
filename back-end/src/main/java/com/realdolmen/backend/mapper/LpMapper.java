package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LpMapper {
    LpDto lpToLpDto(Lp lp);

    Lp lpDtoToLp(LpDto lpDto);
}
