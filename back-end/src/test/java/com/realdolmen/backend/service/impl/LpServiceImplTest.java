package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.repository.LpRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpMetallica;
import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpParanoid;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LpServiceImplTest {
    @InjectMocks
    private LpServiceImpl lpService;
    @Mock
    private LpRepository lpRepository;

    @Test
    public void testShouldInvokeRepoSaveAndAssertEquals() {
        Lp expectedLp = buildLpParanoid().build();

        when(lpRepository.save(any())).thenReturn(expectedLp);

        Lp savedLp = lpService.save(expectedLp);

        verify(lpRepository, times(1)).save(expectedLp);
        assertEquals(expectedLp, savedLp);
    }

    @Test
    public void testShouldInvokeRepoFindByIdAndAssertEquals() {
        Lp expectedLp = buildLpParanoid().build();

        when(lpRepository.save(any())).thenReturn(expectedLp);
        when(lpRepository.findById(any())).thenReturn(Optional.of(expectedLp));

        Long id = lpService.save(expectedLp).getId();
        Lp foundLp = lpService.findById(id);

        verify(lpRepository, times(1)).save(expectedLp);
        verify(lpRepository, times(1)).findById(id);
        assertEquals(expectedLp, foundLp);
    }

    @Test
    public void testShouldInvokeRepoFindAllAndAssertEquals() {
        List<Lp> expectedLps = new ArrayList<>();
        expectedLps.add(buildLpParanoid().build());
        expectedLps.add(buildLpMetallica().build());

        when(lpRepository.findAll()).thenReturn(expectedLps);

        List<Lp> foundLps = lpService.findAll();

        verify(lpRepository, times(1)).findAll();
        assertEquals(2, foundLps.size());
    }

    @Test
    public void testShouldInvokeRepoDeleteAndAssertEquals() {
        Lp lp = buildLpParanoid().build();

        doNothing().when(lpRepository).delete(lp);

        lpService.delete(lp);

        verify(lpRepository, times(1)).delete(lp);
    }
}