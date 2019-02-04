package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
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
    public NonFiction saveNonFiction(NonFictionDto nonFictionDto) {
        NonFiction nonFiction = nonFictionMapper.nonFictionDtoToNonFiction(nonFictionDto);
        return nonFictionService.save(nonFiction);
    }

    @Override
    public NonFictionDto findNonFictionById(Long id) {
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
    public void deleteNonFiction(NonFictionDto nonFictionDto) {
        NonFiction nonFiction = nonFictionMapper.nonFictionDtoToNonFiction(nonFictionDto);
        nonFictionService.delete(nonFiction);
    }
}
