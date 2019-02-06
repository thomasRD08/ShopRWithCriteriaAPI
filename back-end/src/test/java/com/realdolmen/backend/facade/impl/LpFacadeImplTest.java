package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.mapper.LpMapperImpl;
import com.realdolmen.backend.service.LpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpDtoParanoid;
import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpParanoid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LpFacadeImplTest {
    @InjectMocks
    private LpFacadeImpl lpFacade;
    @Mock
    private LpMapperImpl lpMapper;
    @Mock
    private LpService lpService;

    @Test
    public void testShouldMockFacade() {
        assertThat(lpFacade).isNotNull();
    }

    @Test
    public void testShouldSaveLp() {
        LpDto lpDto = buildLpDtoParanoid().build();

        Lp lp = lpFacade.saveLp(lpDto);

        verify(lpService, times(1)).save(lp);
    }

    @Test
    public void testShouldFindLpById() {
        Lp lp = buildLpParanoid().build();
        Long id = lp.getId();

        lpFacade.findLpById(id);

        verify(lpService, times(1)).findById(id);
    }

    @Test
    public void testShouldFindAllLps() {
        lpFacade.findAllLps();

        verify(lpService, times(1)).findAll();
    }

    @Test
    public void testShouldDeleteLp() {
        LpDto lpDto = buildLpDtoParanoid().build();
        Lp lp = lpMapper.lpDtoToLp(lpDto);

        lpFacade.deleteLp(lpDto);

        verify(lpService, times(1)).delete(lp);
    }
}