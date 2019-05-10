package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.mapper.LpMapper;
import com.realdolmen.backend.service.LpService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LpFacadeImplTest {
    @InjectMocks
    private LpFacadeImpl lpFacade;
    @Mock
    private LpService lpService;
    @Mock
    private LpMapper lpMapper;


    @Test
    public void testShouldMockFacade() {
        assertThat(lpFacade).isNotNull();
    }

    @Test
    public void testShouldInvokeServiceSave() {
        LpDto lpDto = new LpDto();

        lpFacade.saveLp(lpDto);

        verify(lpService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceFindById() {
        Long id = 1L;

        lpFacade.findLpById(id);

        verify(lpService, times(1)).findById(id);
    }

    @Test
    public void testShouldInvokeServiceFindAll() {
        lpFacade.findAllLps();

        verify(lpService, times(1)).findAll();
    }

    @Test
    public void testShouldInvokeServiceSaveByUpdate() {
        LpDto lpDto = new LpDto();

        lpFacade.updateLp(lpDto);

        verify(lpService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceDeleteAndArgumentAndReturnMatch() {
        Long id = 1L;
        Lp lp = new Lp();
        when(lpService.findById(id)).thenReturn(lp);
        lpFacade.deleteLp(id);

        ArgumentCaptor<Lp> argumentCaptor = ArgumentCaptor.forClass(Lp.class);
        verify(lpService, times(1)).delete(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isSameAs(lp);
    }
}