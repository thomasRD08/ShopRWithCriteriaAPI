package com.realdolmen.backend.facade;

import com.realdolmen.backend.dto.OrderLineDto;

public interface OrderLineFacade {
    OrderLineDto saveOrderLine(OrderLineDto orderLineDto);
}
