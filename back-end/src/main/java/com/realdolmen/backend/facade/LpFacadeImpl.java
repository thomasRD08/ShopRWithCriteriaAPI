package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
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
    public Lp saveLp(LpDto lpDto) {
        Lp lp = lpMapper.lpDtoToLp(lpDto);
        return lpService.save(lp);
    }

    @Override
    public LpDto findLpById(Long id) {
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
    public void deleteLp(LpDto lpDto) {
        Lp lp = lpMapper.lpDtoToLp(lpDto);
        lpService.delete(lp);
    }
}
