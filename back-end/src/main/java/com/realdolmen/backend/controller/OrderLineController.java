package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.impl.OrderLineFacadeImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-lines")
@AllArgsConstructor
public class OrderLineController {
    private final OrderLineFacadeImpl orderLineFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLineDto createOrderLine(@RequestBody OrderLineDto orderLineDto) {
        return orderLineFacade.saveOrderLine(orderLineDto);
    }
}
