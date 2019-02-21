package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Date timeStamp;
    private UserDto user;
    private List<OrderLineDto> orderLines;
}
