package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {
    OrderLineDto orderLineToOrderLineDto(OrderLine orderLine);

    OrderLine orderLineDtoToOrderLine(OrderLineDto orderLineDto);

    void orderLineDtoToOrderLine(OrderLineDto orderLineDto, @MappingTarget OrderLine orderLine);
}
