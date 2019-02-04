package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.dto.BookDto;
import com.realdolmen.backend.facade.BookFacade;
import com.realdolmen.backend.mapper.BookMapper;
import com.realdolmen.backend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookFacadeImpl implements BookFacade {
    private final BookMapper bookMapper;
    private final BookService bookService;

    @Override
    public List<BookDto> findAllBooks() {
        return bookService.findAll()
                .stream()
                .map(bookMapper::bookToBookDto)
                .collect(Collectors.toList());
    }
}
