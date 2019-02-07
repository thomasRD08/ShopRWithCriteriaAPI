package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.facade.NonFictionFacade;
import com.realdolmen.backend.mapper.NonFictionMapper;
import com.realdolmen.backend.service.NonFictionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class NonFictionFacadeImpl implements NonFictionFacade {
    private final NonFictionMapper nonFictionMapper;
    private final NonFictionService nonFictionService;

    @Override
    public NonFictionDto saveNonFiction(final NonFictionDto nonFictionDto) {
        return save(nonFictionDto, new NonFiction());
    }

    @Override
    public NonFictionDto findNonFictionById(final Long id) {
        NonFiction nonFiction = nonFictionService.findById(id);
        return nonFictionMapper.nonFictionToNonFictionDto(nonFiction);
    }

    @Override
    public List<NonFictionDto> findAllNonFiction() {
        return nonFictionService.findAll()
                .stream()
                .map(nonFictionMapper::nonFictionToNonFictionDto)
                .collect(Collectors.toList());
    }

    @Override
    public NonFictionDto updateNonFiction(final NonFictionDto nonFictionDto) {
        NonFiction nonFiction = nonFictionService.findById(nonFictionDto.getId());
        return save(nonFictionDto, nonFiction);
    }

    @Override
    public void deleteNonFiction(final Long id) {
        NonFiction nonFiction = nonFictionService.findById(id);
        nonFictionService.delete(nonFiction);
    }

    private NonFictionDto save(NonFictionDto nonFictionDto, NonFiction nonFiction) {
        nonFictionMapper.nonFictionDtoToNonFiction(nonFictionDto, nonFiction);
        nonFiction = nonFictionService.save(nonFiction);
        return nonFictionMapper.nonFictionToNonFictionDto(nonFiction);
    }
}
