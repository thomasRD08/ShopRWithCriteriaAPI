package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.facade.impl.OrderFacadeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderFacadeImpl orderFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto save(@RequestBody @Valid OrderDto orderDto) {
        return orderFacade.saveOrder(orderDto);
    }
}
