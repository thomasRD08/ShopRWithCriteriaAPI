package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OrderLineMapper.class)
public interface OrderMapper {
    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);
}
