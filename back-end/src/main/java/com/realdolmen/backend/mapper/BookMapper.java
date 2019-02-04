package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
