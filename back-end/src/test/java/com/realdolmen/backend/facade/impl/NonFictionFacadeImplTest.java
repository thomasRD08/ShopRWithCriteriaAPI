package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.mapper.NonFictionMapper;
import com.realdolmen.backend.service.NonFictionService;
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
public class NonFictionFacadeImplTest {
    @InjectMocks
    private NonFictionFacadeImpl nonFictionFacade;
    @Mock
    private NonFictionService nonFictionService;
    @Mock
    private NonFictionMapper nonFictionMapper;

    @Test
    public void testShouldMockFacade() {
        assertThat(nonFictionFacade).isNotNull();
    }

    @Test
    public void testShouldInvokeServiceSave() {
        NonFictionDto nonFictionDto = new NonFictionDto();

        nonFictionFacade.saveNonFiction(nonFictionDto);

        verify(nonFictionService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceFindById() {
        Long id = 1L;

        nonFictionFacade.findNonFictionById(id);

        verify(nonFictionService, times(1)).findById(id);
    }

    @Test
    public void testShouldInvokeServiceFindAll() {
        nonFictionFacade.findAllNonFiction();

        verify(nonFictionService, times(1)).findAll();
    }

    @Test
    public void testShouldInvokeServiceSaveByUpdate() {
        NonFictionDto nonFictionDto = new NonFictionDto();

        nonFictionFacade.updateNonFiction(nonFictionDto);

        verify(nonFictionService, times(1)).save(any());
    }

    @Test
    public void testShouldInvokeServiceDeleteAndArgumentAndReturnMatch() {
        Long id = 1L;
        NonFiction nonFiction = new NonFiction();
        when(nonFictionService.findById(id)).thenReturn(nonFiction);
        nonFictionFacade.deleteNonFiction(id);

        ArgumentCaptor<NonFiction> argumentCaptor = ArgumentCaptor.forClass(NonFiction.class);
        verify(nonFictionService, times(1)).delete(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isSameAs(nonFiction);
    }
}
