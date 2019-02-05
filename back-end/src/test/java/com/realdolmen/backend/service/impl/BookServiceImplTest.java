package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    public void testShouldFindAllBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Fiction());
        expectedBooks.add(new NonFiction());

        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> foundBooks = bookService.findAll();

        verify(bookRepository, times(1)).findAll();
        assertEquals(2, foundBooks.size());
    }
}