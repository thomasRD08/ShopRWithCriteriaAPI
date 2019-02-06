package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.mapper.FictionMapperImpl;
import com.realdolmen.backend.service.FictionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionDtoTheHelp;
import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionTheHelp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FictionFacadeImplTest {
    @InjectMocks
    private FictionFacadeImpl fictionFacade;
    @Mock
    private FictionMapperImpl fictionMapper;
    @Mock
    private FictionService fictionService;

    @Test
    public void testShouldMockFacade() {
        assertThat(fictionFacade).isNotNull();
    }

    @Test
    public void testShouldSaveFiction() {
        FictionDto fictionDto = buildFictionDtoTheHelp().build();

        Fiction fiction = fictionFacade.saveFiction(fictionDto);

        verify(fictionService, times(1)).save(fiction);
    }

    @Test
    public void testShouldFindFictionById() {
        Fiction fiction = buildFictionTheHelp().build();
        Long id = fiction.getId();

        fictionFacade.findFictionById(id);

        verify(fictionService, times(1)).findById(id);
    }

    @Test
    public void testShouldFindAllFiction() {
        fictionFacade.findAllFiction();

        verify(fictionService, times(1)).findAll();
    }

    @Test
    public void testShouldDeleteFiction() {
        FictionDto fictionDto = buildFictionDtoTheHelp().build();
        Fiction fiction = fictionMapper.fictionDtoToFiction(fictionDto);

        fictionFacade.deleteFiction(fictionDto);

        verify(fictionService, times(1)).delete(fiction);
    }
}
