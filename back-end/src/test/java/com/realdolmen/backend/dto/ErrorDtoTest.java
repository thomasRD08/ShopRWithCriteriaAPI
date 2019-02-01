package com.realdolmen.backend.dto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.rules.ExpectedException.none;

public class ErrorDtoTest {
    @Rule
    public ExpectedException expectedException = none();

    @Test
    public void testSuccess() {
        ErrorDto.builder()
                .httpStatus(404)
                .message("test")
                .build();
    }

    @Test
    public void testFailOnMissingMessage() {
        expectedException.expect(NullPointerException.class);

        ErrorDto.builder()
                .httpStatus(404)
                .build();
    }

    @Test
    public void testFailOnMissingHttpStatus() {
        expectedException.expect(NullPointerException.class);

        ErrorDto.builder()
                .message("test")
                .build();
    }
}