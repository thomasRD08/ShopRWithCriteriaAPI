package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.service.LpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpParanoid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

//TODO: Fix tests
//@ContextConfiguration(classes = SpringTestConfig.class)
@RunWith(MockitoJUnitRunner.class)
public class LpFacadeImplTest {
    @InjectMocks
    private LpFacadeImpl lpFacade;
    @Mock
    private LpService lpService;


    @Test
    public void testShouldMockFacade() {
        assertThat(lpFacade).isNotNull();
    }

//    @Test
//    public void testShouldSaveLp() {
//        LpDto lpDto = buildLpDtoParanoid().build();
//
//        lpDto = lpFacade.saveLp(lpDto);
//        Lp lp = null; //lpMapper.lpDtoToLp(lpDto);
//
//        verify(lpService, times(1)).save(any());
//    }

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
//        LpMapper mapper = Mappers.getMapper(LpMapper.class);
        Long id = 1L;
        Lp lp = new Lp();
        when(lpService.findById(id)).thenReturn(lp);
        lpFacade.deleteLp(id);

        ArgumentCaptor<Lp> argumentCaptor = ArgumentCaptor.forClass(Lp.class);
        verify(lpService, times(1)).delete(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isSameAs(lp);
    }
}