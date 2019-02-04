package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.BookDto;

import java.util.List;

public interface BookFacade {
    List<BookDto> findAllBooks();
}
