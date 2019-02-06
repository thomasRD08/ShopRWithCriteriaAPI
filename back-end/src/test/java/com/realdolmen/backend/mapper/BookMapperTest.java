package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.dto.BookDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.realdolmen.backend.data.FictionTestDataBuilder.buildFictionTheHelp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class BookMapperTest {
    @InjectMocks
    private BookMapperImpl bookMapper;

    @Test
    public void testMapperShouldConvertToDto() {
        Book book = buildFictionTheHelp().build();

        BookDto testBookDto = bookMapper.bookToBookDto(book);

        assertEquals(book.getTitle(), testBookDto.getTitle());
        assertEquals(book.getPrice(), testBookDto.getPrice());
        assertEquals(book.getType(), testBookDto.getType());
        assertEquals(book.getAuthor(), testBookDto.getAuthor());
        assertEquals(book.getIsbn(), testBookDto.getIsbn());
        assertEquals(book.getPages(), testBookDto.getPages());
    }

    @Test
    public void testMapperConvertEmptyBookShouldReturnNull() {
        BookDto testBookDto = bookMapper.bookToBookDto(null);

        assertNull(testBookDto);
    }
}
