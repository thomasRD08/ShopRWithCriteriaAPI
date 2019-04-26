package com.realdolmen.backend.constraint;

import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.dto.OrderLineDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderValidator implements ConstraintValidator<Order, OrderDto> {
    @Override
    public void initialize(Order constraintAnnotation) {
    }

    @Override
    public boolean isValid(OrderDto orderDto, ConstraintValidatorContext context) {
        if (orderDto.getUser() == null) {
            return false;
        }

        for (OrderLineDto orderLineDto : orderDto.getOrderLines()) {
            if (orderLineDto.getAmount() == null) {
                return false;
            } else if (orderLineDto.getProduct() == null) {
                return false;
            }
        }
        return true;
    }
}
