package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpDtoParanoid;
import static com.realdolmen.backend.data.LpTestDataBuilder.buildLpParanoid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class LpMapperTest {
    @InjectMocks
    private LpMapperImpl lpMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        Lp lp = buildLpParanoid().build();

        LpDto testLpDto = lpMapper.lpToLpDto(lp);

        assertEquals(lp.getTitle(), testLpDto.getTitle());
        assertEquals(lp.getPrice(), testLpDto.getPrice());
        assertEquals(lp.getType(), testLpDto.getType());
        assertEquals(lp.getArtist(), testLpDto.getArtist());
        assertEquals(lp.getLpGenre(), testLpDto.getLpGenre());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        LpDto lpDto = buildLpDtoParanoid().build();

        Lp testLp = lpMapper.lpDtoToLp(lpDto);

        assertEquals(lpDto.getTitle(), testLp.getTitle());
        assertEquals(lpDto.getPrice(), testLp.getPrice());
        assertEquals(lpDto.getType(), testLp.getType());
        assertEquals(lpDto.getArtist(), testLp.getArtist());
        assertEquals(lpDto.getLpGenre(), testLp.getLpGenre());
    }

    @Test
    public void testMapperConvertEmptyLpShouldReturnNull() {
        LpDto testLpDto = lpMapper.lpToLpDto(null);

        assertNull(testLpDto);
    }

    @Test
    public void testMapperConvertEmptyLpDtoShouldReturnNull() {
        Lp testLp = lpMapper.lpDtoToLp(null);

        assertNull(testLp);
    }
}
