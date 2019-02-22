package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderLineMapper {
    OrderLineDto orderLineToOrderLineDto(OrderLine orderLine);

    OrderLine orderLineDtoToOrderLine(OrderLineDto orderLineDto);
}
