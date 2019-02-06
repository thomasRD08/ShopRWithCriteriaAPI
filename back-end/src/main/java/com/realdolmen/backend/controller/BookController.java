package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.BookDto;
import com.realdolmen.backend.facade.impl.BookFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookFacadeImpl bookFacade;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookFacade.findAllBooks();
    }
}
