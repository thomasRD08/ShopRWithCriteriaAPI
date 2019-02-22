package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.repository.FictionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionTheHelp;
import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionTheKiteRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FictionServiceImplTest {
    @InjectMocks
    private FictionServiceImpl fictionService;
    @Mock
    private FictionRepository fictionRepository;

    @Test
    public void testShouldInvokeRepoSaveAndAssertEquals() {
        Fiction expectedFiction = buildFictionTheHelp().build();

        when(fictionRepository.save(any())).thenReturn(expectedFiction);

        Fiction savedFiction = fictionService.save(expectedFiction);

        verify(fictionRepository, times(1)).save(expectedFiction);
        assertEquals(expectedFiction, savedFiction);
    }

    @Test
    public void testShouldInvokeRepoFindByIdAndAssertEquals() {
        Fiction expectedFiction = buildFictionTheHelp().build();

        when(fictionRepository.save(any())).thenReturn(expectedFiction);
        when(fictionRepository.findById(any())).thenReturn(Optional.of(expectedFiction));

        Long id = fictionService.save(expectedFiction).getId();
        Fiction foundFiction = fictionService.findById(id);

        verify(fictionRepository, times(1)).save(expectedFiction);
        verify(fictionRepository, times(1)).findById(id);
        assertEquals(expectedFiction, foundFiction);
    }

    @Test
    public void testShouldInvokeRepoFindAllAndAssertEquals() {
        List<Fiction> expectedFiction = new ArrayList<>();
        expectedFiction.add(buildFictionTheHelp().build());
        expectedFiction.add(buildFictionTheKiteRunner().build());

        when(fictionRepository.findAll()).thenReturn(expectedFiction);

        List<Fiction> foundFiction = fictionService.findAll();

        verify(fictionRepository, times(1)).findAll();
        assertEquals(2, foundFiction.size());
    }

    @Test
    public void testShouldInvokeRepoDeleteAndAssertEquals() {
        Fiction fiction = buildFictionTheHelp().build();

        doNothing().when(fictionRepository).delete(fiction);

        fictionService.delete(fiction);

        verify(fictionRepository, times(1)).delete(fiction);
    }
}