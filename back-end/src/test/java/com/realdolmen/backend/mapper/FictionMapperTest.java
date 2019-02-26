package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionDtoTheHelp;
import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionTheHelp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class FictionMapperTest {
    @InjectMocks
    private FictionMapperImpl fictionMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        Fiction fiction = buildFictionTheHelp().build();

        FictionDto testFictionDto = fictionMapper.fictionToFictionDto(fiction);

        assertEquals(fiction.getTitle(), testFictionDto.getTitle());
        assertEquals(fiction.getPrice(), testFictionDto.getPrice());
        assertEquals(fiction.getType(), testFictionDto.getType());
        assertEquals(fiction.getAuthor(), testFictionDto.getAuthor());
        assertEquals(fiction.getIsbn(), testFictionDto.getIsbn());
        assertEquals(fiction.getPages(), testFictionDto.getPages());
        assertEquals(fiction.getSummary(), testFictionDto.getSummary());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        FictionDto fictionDto = buildFictionDtoTheHelp().build();

        Fiction testFiction = fictionMapper.fictionDtoToFiction(fictionDto);

        assertEquals(fictionDto.getTitle(), testFiction.getTitle());
        assertEquals(fictionDto.getPrice(), testFiction.getPrice());
        assertEquals(fictionDto.getType(), testFiction.getType());
        assertEquals(fictionDto.getAuthor(), testFiction.getAuthor());
        assertEquals(fictionDto.getIsbn(), testFiction.getIsbn());
        assertEquals(fictionDto.getPages(), testFiction.getPages());
        assertEquals(fictionDto.getSummary(), testFiction.getSummary());
    }

    @Test
    public void testMapperConvertEmptyFictionShouldReturnNull() {
        FictionDto testFictionDto = fictionMapper.fictionToFictionDto(null);

        assertNull(testFictionDto);
    }

    @Test
    public void testMapperConvertEmptyFictionDtoShouldReturnNull() {
        Fiction testFiction = fictionMapper.fictionDtoToFiction(null);

        assertNull(testFiction);
    }
}
