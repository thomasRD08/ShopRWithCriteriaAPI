package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.facade.OrderFacade;
import com.realdolmen.backend.mapper.OrderLineMapper;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderFacadeImpl implements OrderFacade {
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    private final OrderLineMapper orderLineMapper;
    private final OrderService orderService;

    @Override
    public OrderDto saveOrder(final OrderDto orderDto) {
        return save(orderDto, new Order());
    }

    private OrderDto save(OrderDto orderDto, Order order) {
        orderMapper.orderDtoToOrder(orderDto, order);
        order.setUser(userMapper.userDtoToUser(orderDto.getUser()));
        List<OrderLine> orderLines = orderDto.getOrderLines()
                .stream()
                .map(orderLineMapper::orderLineDtoToOrderLine)
                .collect(Collectors.toList());
        order.setOrderLines(orderLines);
        order = orderService.save(order);
        return orderMapper.orderToOrderDto(order);
    }
}
