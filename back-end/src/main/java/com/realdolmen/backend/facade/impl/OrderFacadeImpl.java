package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.facade.OrderFacade;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderFacadeImpl implements OrderFacade {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto saveOrder(final OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        order = orderService.save(order);
        return orderMapper.orderToOrderDto(order);
    }
}
