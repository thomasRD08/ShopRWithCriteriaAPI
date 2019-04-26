package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Order;

public interface OrderService extends CrudService<Order, Long> {
    Order save(Order order);
}
