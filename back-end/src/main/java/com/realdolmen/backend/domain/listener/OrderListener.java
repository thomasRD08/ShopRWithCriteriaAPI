package com.realdolmen.backend.domain.listener;

import com.realdolmen.backend.domain.Order;

import javax.persistence.PrePersist;
import java.util.Date;

public class OrderListener {
    @PrePersist
    public void persist(Object object) {
        Order order = (Order) object;
        order.setTimeStamp(new Date());
    }
}
