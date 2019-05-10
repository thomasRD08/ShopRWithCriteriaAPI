package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.mapper.FictionMapper;
import com.realdolmen.backend.service.FictionService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FictionFacadeImplTest {
    @InjectMocks
    private FictionFacadeImpl fictionFacade;
    @Mock
    private FictionService fictionService;
    @Mock
    private FictionMapper fictionMapper;

    @Test
    public void testShouldMockFacade() {
        assertThat(fictionFacade).isNotNull();
    }

    @Test
    public void testShouldInvokeServiceSave() {
        FictionDto fictionDto = new FictionDto();

        fictionFacade.saveFiction(fictionDto);

        verify(fictionService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceFindById() {
        Long id = 1L;

        fictionFacade.findFictionById(id);

        verify(fictionService, times(1)).findById(id);
    }

    @Test
    public void testShouldInvokeServiceFindAll() {
        fictionFacade.findAllFiction();

        verify(fictionService, times(1)).findAll();
    }

    @Test
    public void testShouldInvokeServiceSaveByUpdate() {
        FictionDto fictionDto = new FictionDto();

        fictionFacade.updateFiction(fictionDto);

        verify(fictionService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceDeleteAndArgumentAndReturnMatch() {
        Long id = 1L;
        Fiction fiction = new Fiction();
        when(fictionService.findById(id)).thenReturn(fiction);
        fictionFacade.deleteFiction(id);

        ArgumentCaptor<Fiction> argumentCaptor = ArgumentCaptor.forClass(Fiction.class);
        verify(fictionService, times(1)).delete(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isSameAs(fiction);
    }
}
