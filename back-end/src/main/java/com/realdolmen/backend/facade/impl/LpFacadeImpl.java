package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.facade.LpFacade;
import com.realdolmen.backend.mapper.LpMapper;
import com.realdolmen.backend.service.LpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LpFacadeImpl implements LpFacade {
    private final LpMapper lpMapper;
    private final LpService lpService;

    @Override
    public LpDto saveLp(final LpDto lpDto) {
        return save(lpDto, new Lp());
    }

    @Override
    public LpDto findLpById(final Long id) {
        Lp lp = lpService.findById(id);
        return lpMapper.lpToLpDto(lp);
    }

    @Override
    public List<LpDto> findAllLps() {
        return lpService.findAll()
                .stream()
                .map(lpMapper::lpToLpDto)
                .collect(Collectors.toList());
    }

    @Override
    public LpDto updateLp(final LpDto lpDto) {
        Lp lp = lpService.findById(lpDto.getId());
        return save(lpDto, lp);
    }

    @Override
    public void deleteLp(final Long id) {
        Lp lp = lpService.findById(id);
        lpService.delete(lp);
    }

    private LpDto save(LpDto lpDto, Lp lp) {
        lpMapper.lpDtoToLp(lpDto, lp);
        lp = lpService.save(lp);
        return lpMapper.lpToLpDto(lp);
    }
}
