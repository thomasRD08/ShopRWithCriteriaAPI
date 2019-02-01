package com.realdolmen.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

@Getter
@Builder(builderClassName = "Builder")
public class ErrorDto {
    @NonNull
    private final Integer httpStatus;
    @NonNull
    @Singular
    private final List<String> messages;
}
