package com.realdolmen.backend.dto;

import com.realdolmen.backend.constraint.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Order
public class OrderDto {
    private Long id;
    private Date timeStamp;
    private UserDto user;
    private List<OrderLineDto> orderLines;
}
