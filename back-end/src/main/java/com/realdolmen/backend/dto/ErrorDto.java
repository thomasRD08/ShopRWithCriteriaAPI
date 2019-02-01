package com.realdolmen.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Getter
@Builder(builderClassName = "Builder")
public class ErrorDto {
    private final Integer httpStatus;
    @Singular
    private final List<String> messages;

    public ErrorDto(@NonNull Integer httpStatus, @NonNull List<String> messages) {
        if(isEmpty(messages)) throw new NullPointerException();
        this.httpStatus = httpStatus;
        this.messages = messages;
    }
}
