package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.NonFictionRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.backend.data.NonFictionTestDataBuilder.buildNonFictionAncientEgypt;
import static com.realdolmen.backend.data.NonFictionTestDataBuilder.buildNonFictionCooking;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NonFictionServiceImplTest {
    @InjectMocks
    private NonFictionServiceImpl nonFictionService;
    @Mock
    private NonFictionRepository nonFictionRepository;

    @Test
    public void testShouldInvokeRepoSaveAndAssertEquals() {
        NonFiction expectedNonFiction = buildNonFictionAncientEgypt().build();

        when(nonFictionRepository.save(any())).thenReturn(expectedNonFiction);

        NonFiction savedNonFiction = nonFictionService.save(expectedNonFiction);

        verify(nonFictionRepository, times(1)).save(expectedNonFiction);
        assertEquals(expectedNonFiction, savedNonFiction);
    }

    @Test
    public void testShouldInvokeRepoFindByIdAndAssertEquals() {
        NonFiction expectedNonFiction = buildNonFictionAncientEgypt().build();

        when(nonFictionRepository.save(any())).thenReturn(expectedNonFiction);
        when(nonFictionRepository.findById(any())).thenReturn(Optional.of(expectedNonFiction));

        Long id = nonFictionService.save(expectedNonFiction).getId();
        NonFiction foundNonFiction = nonFictionService.findById(id);

        verify(nonFictionRepository, times(1)).save(expectedNonFiction);
        verify(nonFictionRepository, times(1)).findById(id);
        assertEquals(expectedNonFiction, foundNonFiction);
    }

    @Test
    public void testShouldInvokeRepoFindAllAndAssertEquals() {
        List<NonFiction> expectedNonFiction = new ArrayList<>();
        expectedNonFiction.add(buildNonFictionAncientEgypt().build());
        expectedNonFiction.add(buildNonFictionCooking().build());

        when(nonFictionRepository.findAll()).thenReturn(expectedNonFiction);

        List<NonFiction> foundNonFiction = nonFictionService.findAll();

        verify(nonFictionRepository, times(1)).findAll();
        assertEquals(2, foundNonFiction.size());
    }

    @Test
    public void testShouldInvokeRepoDeleteAndAssertEquals() {
        NonFiction nonFiction = buildNonFictionAncientEgypt().build();

        doNothing().when(nonFictionRepository).delete(nonFiction);

        nonFictionService.delete(nonFiction);

        verify(nonFictionRepository, times(1)).delete(nonFiction);
    }
}