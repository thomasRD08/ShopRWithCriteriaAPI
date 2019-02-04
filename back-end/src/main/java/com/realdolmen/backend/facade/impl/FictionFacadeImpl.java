package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.facade.FictionFacade;
import com.realdolmen.backend.mapper.FictionMapper;
import com.realdolmen.backend.service.FictionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FictionFacadeImpl implements FictionFacade {
    private final FictionMapper fictionMapper;
    private final FictionService fictionService;

    @Override
    public Fiction saveFiction(FictionDto fictionDto) {
        Fiction fiction = fictionMapper.fictionDtoToFiction(fictionDto);
        return fictionService.save(fiction);
    }

    @Override
    public FictionDto findFictionById(Long id) {
        Fiction fiction = fictionService.findById(id);
        return fictionMapper.fictionToFictionDto(fiction);
    }

    @Override
    public List<FictionDto> findAllFiction() {
        return fictionService.findAll()
                .stream()
                .map(fictionMapper::fictionToFictionDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFiction(FictionDto fictionDto) {
        Fiction fiction = fictionMapper.fictionDtoToFiction(fictionDto);
        fictionService.delete(fiction);
    }
}
