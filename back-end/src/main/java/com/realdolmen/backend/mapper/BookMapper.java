package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    default BookDto bookToBookDto(Book book) {
        return null; //todo delete
    }
}
