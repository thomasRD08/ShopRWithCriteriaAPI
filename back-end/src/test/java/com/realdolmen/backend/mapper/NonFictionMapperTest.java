package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.NonFictionTestDataBuilder.buildNonFictionAncientEgypt;
import static com.realdolmen.backend.data.NonFictionTestDataBuilder.buildNonFictionDtoAncientEgypt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class NonFictionMapperTest {
    @InjectMocks
    private NonFictionMapperImpl nonFictionMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        NonFiction nonFiction = buildNonFictionAncientEgypt().build();

        NonFictionDto testNonFictionDto = nonFictionMapper.nonFictionToNonFictionDto(nonFiction);

        assertEquals(nonFiction.getTitle(), testNonFictionDto.getTitle());
        assertEquals(nonFiction.getPrice(), testNonFictionDto.getPrice());
        assertEquals(nonFiction.getType(), testNonFictionDto.getType());
        assertEquals(nonFiction.getAuthor(), testNonFictionDto.getAuthor());
        assertEquals(nonFiction.getIsbn(), testNonFictionDto.getIsbn());
        assertEquals(nonFiction.getPages(), testNonFictionDto.getPages());
    }

    @Test
    public void testMapperShouldConvertFromDto() {
        NonFictionDto nonFictionDto = buildNonFictionDtoAncientEgypt().build();

        NonFiction testNonFiction = nonFictionMapper.nonFictionDtoToNonFiction(nonFictionDto);

        assertEquals(nonFictionDto.getTitle(), testNonFiction.getTitle());
        assertEquals(nonFictionDto.getPrice(), testNonFiction.getPrice());
        assertEquals(nonFictionDto.getType(), testNonFiction.getType());
        assertEquals(nonFictionDto.getAuthor(), testNonFiction.getAuthor());
        assertEquals(nonFictionDto.getIsbn(), testNonFiction.getIsbn());
        assertEquals(nonFictionDto.getPages(), testNonFiction.getPages());
    }

    @Test
    public void testMapperConvertEmptyNonFictionShouldReturnNull() {
        NonFictionDto testNonFictionDto = nonFictionMapper.nonFictionToNonFictionDto(null);

        assertNull(testNonFictionDto);
    }

    @Test
    public void testMapperConvertEmptyNonFictionDtoShouldReturnNull() {
        NonFiction testNonFiction = nonFictionMapper.nonFictionDtoToNonFiction(null);

        assertNull(testNonFiction);
    }
}