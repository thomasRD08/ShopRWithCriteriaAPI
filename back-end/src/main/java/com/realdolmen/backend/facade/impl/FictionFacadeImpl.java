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
    public FictionDto saveFiction(final FictionDto fictionDto) {
        return save(fictionDto, new Fiction());
    }

    @Override
    public FictionDto findFictionById(final Long id) {
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
    public FictionDto updateFiction(final FictionDto fictionDto) {
        Fiction fiction = fictionService.findById(fictionDto.getId());
        return save(fictionDto, fiction);
    }

    @Override
    public void deleteFiction(final Long id) {
        Fiction fiction = fictionService.findById(id);
        fictionService.delete(fiction);
    }

    private FictionDto save(FictionDto fictionDto, Fiction fiction) {
        fictionMapper.fictionDtoToFiction(fictionDto, fiction);
        fiction= fictionService.save(fiction);
        return fictionMapper.fictionToFictionDto(fiction);
    }
}
