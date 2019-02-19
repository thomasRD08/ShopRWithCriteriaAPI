package com.realdolmen.backend.facade.impl;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.OrderLineFacade;
import com.realdolmen.backend.mapper.OrderLineMapper;
import com.realdolmen.backend.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderLineFacadeImpl implements OrderLineFacade {
    private final OrderLineMapper orderLineMapper;
    private final OrderLineService orderLineService;

    @Override
    public OrderLineDto saveOrderLine(final OrderLineDto orderLineDto) {
        return save(orderLineDto, new OrderLine());
    }

    private OrderLineDto save(OrderLineDto orderLineDto, OrderLine orderLine) {
        orderLineMapper.orderLineDtoToOrderLine(orderLineDto, orderLine);
        orderLine = orderLineService.save(orderLine);
        return orderLineMapper.orderLineToOrderLineDto(orderLine);
    }
}
