package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookFacadeImplTest {
    @InjectMocks
    private BookFacadeImpl bookFacade;
    @Mock
    private BookService bookService;

    @Test
    public void testShouldMockFacade() {
        assertThat(bookFacade).isNotNull();
    }

    @Test
    public void testShouldFindAllBooks() {
        bookFacade.findAllBooks();

        verify(bookService, times(1)).findAll();
    }
}
