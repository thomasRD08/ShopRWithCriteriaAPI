package com.realdolmen.backend.dto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.rules.ExpectedException.none;

public class ErrorDtoTest {
    @Rule
    public ExpectedException expectedException = none();

    @Test
    public void testOnSuccess() {
        ErrorDto.builder()
                .httpStatus(404)
                .message("Test")
                .build();
    }

    @Test
    public void testOnFailOnMissingMessage() {
        expectedException.expect(NullPointerException.class);

        ErrorDto.builder()
                .httpStatus(404)
                .build();
    }

    @Test
    public void testOnFailOnMissingHttpStatus() {
        expectedException.expect(NullPointerException.class);

        ErrorDto.builder()
                .message("Test")
                .build();
    }
}