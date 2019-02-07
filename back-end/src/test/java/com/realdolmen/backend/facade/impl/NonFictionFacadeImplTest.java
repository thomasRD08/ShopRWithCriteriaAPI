package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.service.NonFictionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.NonFictionTestDataBuilder.buildNonFictionAncientEgypt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//TODO: Fix tests
@RunWith(MockitoJUnitRunner.class)
public class NonFictionFacadeImplTest {
    @InjectMocks
    private NonFictionFacadeImpl nonFictionFacade;
    @Mock
    private NonFictionService nonFictionService;

    @Test
    public void testShouldMockFacade() {
        assertThat(nonFictionFacade).isNotNull();
    }

//    @Test
//    public void testShouldSaveNonFiction() {
//        NonFictionDto nonFictionDto = buildNonFictionDtoAncientEgypt().build();
//
//        NonFiction nonFiction = nonFictionFacade.saveNonFiction(nonFictionDto);
//
//        verify(nonFictionService, times(1)).save(nonFiction);
//    }

    @Test
    public void testShouldFindNonFictionById() {
        NonFiction nonFiction = buildNonFictionAncientEgypt().build();
        Long id = nonFiction.getId();

        nonFictionFacade.findNonFictionById(id);

        verify(nonFictionService, times(1)).findById(id);
    }

    @Test
    public void testShouldFindAllNonFiction() {
        nonFictionFacade.findAllNonFiction();

        verify(nonFictionService, times(1)).findAll();
    }

//    @Test
//    public void testShouldDeleteNonFiction() {
//        NonFictionDto nonFictionDto = buildNonFictionDtoAncientEgypt().build();
//        NonFiction nonFiction = nonFictionMapper.nonFictionDtoToNonFiction(nonFictionDto);
//
//        nonFictionFacade.deleteNonFiction(nonFictionDto);
//
//        verify(nonFictionService, times(1)).delete(nonFiction);
//    }
}
