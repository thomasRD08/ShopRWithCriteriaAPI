package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.OrderDto;

public interface OrderFacade {
    OrderDto saveOrder(OrderDto orderDto);
}
