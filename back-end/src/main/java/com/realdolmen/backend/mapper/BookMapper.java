package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto bookToBookDto(Book book);
}
